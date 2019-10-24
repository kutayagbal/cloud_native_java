package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	private Long ACCOUNT_NO = 654321L;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void findUserAccountsShouldReturnAccounts() throws Exception {
		this.entityManager.persist(new Account("Jack", 654321L));

		List<Account> accounts = this.accountRepository.findAccountsByUsername("Jack");

		assertThat(accounts.size()).isEqualTo(1);

		Account actual = accounts.get(0);

		assertThat(actual.getAccountNo()).isEqualTo(ACCOUNT_NO);
		assertThat(actual.getUsername()).isEqualTo("Jack");
	}

	@Test
	public void findAccountShouldReturnAccount() {
		this.entityManager.persist(new Account("jill", ACCOUNT_NO));

		Account account = this.accountRepository.findAccountsByAccountNo(ACCOUNT_NO);

		assertThat(account).isNotNull();
		assertThat(account.getAccountNo()).isEqualTo(ACCOUNT_NO);

	}

	@Test
	public void findAccountShouldReturnNull() throws Exception {
		this.entityManager.persist(new Account("jack", ACCOUNT_NO));

		Account account = this.accountRepository.findAccountsByAccountNo(12653761L);
		assertThat(account).isNull();
	}
}
