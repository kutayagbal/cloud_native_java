package com.example.demo;

import static org.mockito.Mockito.mock;

import java.security.Principal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@MockBean
	private AuthService authService;

	private String jsonContent = "{\"username\":\"test_user\",\"firstName\":\"test_name\",\"lastName\":\"test_surname\",\"email\":\"test@test_mail.com\"}";

	@Test
	public void getUserShouldReturnUser() throws Exception {
		Principal principal = mock(Principal.class);

		BDDMockito.given(authService.getAuthenticatedUser(principal)).willReturn(principal);

		BDDMockito.given(userService.getUserByPrincipal(principal))
				.willReturn(new User("test_user", "test_name", "test_surname", "test@test_mail.com"));

		this.mvc.perform(MockMvcRequestBuilders.get("/user/getuser").principal(principal))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonContent));
	}
}
