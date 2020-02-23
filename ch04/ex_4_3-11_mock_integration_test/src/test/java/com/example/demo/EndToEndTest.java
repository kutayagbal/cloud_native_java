package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EndToEndTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void getUserAccountShouldReturnAccount() throws Exception {
		String content = "{\"id\":\"1\",\"username\":\"userAcc\",\"accountNo\":12345678}";

		this.mvc.perform(post("/create_account").contentType("application/json").content(content)).andExpect(status().isOk());
		
		List<Account> accounts = this.accountRepository.findAccountsByUsername("userAcc");

		assertThat(accounts.size()).isEqualTo(1);

		Account actual = accounts.get(0);

		assertThat(actual.getAccountNo()).isEqualTo(12345678);
		assertThat(actual.getUsername()).isEqualTo("userAcc");
	}

}
