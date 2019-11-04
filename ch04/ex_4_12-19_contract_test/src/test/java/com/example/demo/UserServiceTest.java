package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@MockBean
	private UserRepo userRepo;

	private UserService userService;

	@Before
	public void before() {
		userService = new UserService(userRepo);
	}

	@Test
	public void getUserShouldReturnUser() {
		Principal principal = mock(Principal.class);

		BDDMockito.given(userRepo.findUserByUsername(principal.getName()))
				.willReturn(new User("test_user", "test_name", "test_surname", "test@test_mail.com"));

		User user = userService.getUserByPrincipal(principal);

		assertThat(user).isNotNull();
		assertThat(user.getUsername()).isEqualTo("test_user");
		assertThat(user.getFirstName()).isEqualTo("test_name");
		assertThat(user.getLastName()).isEqualTo("test_surname");
		assertThat(user.getEmail()).isEqualTo("test@test_mail.com");
	}

}
