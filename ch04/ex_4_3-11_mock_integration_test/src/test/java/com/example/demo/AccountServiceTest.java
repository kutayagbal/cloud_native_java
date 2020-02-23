package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;
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
		Account acc = new Account();
		acc.setAccountNo(12345L);
		acc.setUsername("new_acc");
		given(accountRepository.findById(12345L)).willReturn(Optional.of((acc)));

		given(userService.getAuthenticatedUser()).willReturn(new User(0L, "John Doe", 12345L));

		Optional<Account> actual = accountService.getUserAccount();

		assertThat(actual.get()).isNotNull();
		assertThat(actual.get().getUsername()).isEqualTo("new_acc");
		assertThat(actual.get().getAccountNo()).isEqualTo(12345L);
	}

	@Test
	public void getUserAccountsReturnsSingleAccount() throws Exception {
		Account acc = new Account();
		acc.setAccountNo(12345L);
		acc.setUsername("user");

		given(accountRepository.findAccountsByUsername("John")).willReturn(Collections.singletonList(acc));

		given(userService.getAuthenticatedUser()).willReturn(new User(0L, "John", null));

		List<Account> actual = accountService.getUserAccounts();

		assertThat(actual.get(0)).isNotNull();
		assertThat(actual.get(0).getUsername()).isEqualTo("user");
		assertThat(actual.get(0).getAccountNo()).isEqualTo(12345L);
	}
}
