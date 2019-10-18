package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

	@MockBean
	private UserService userService;

	@MockBean
	private AccountRepository accountRepository;

	private AccountService accountService;

	@Before
	public void before() {
		accountService = new AccountService(accountRepository, userService);
	}

	@Test
	public void getUserAccountReturnsSingleAccount() throws Exception {
		given(accountRepository.findById(12345L)).willReturn(Optional.of((new Account("new_acc", 12345L))));

		given(userService.getAuthenticatedUser()).willReturn(new User(0L, "John Doe", 12345L));

		Optional<Account> actual = accountService.getUserAccount();

		assertThat(actual.get()).isNotNull();
		assertThat(actual.get().getAccountName()).isEqualTo("new_acc");
		assertThat(actual.get().getAccountNo()).isEqualTo(12345L);
	}
}
