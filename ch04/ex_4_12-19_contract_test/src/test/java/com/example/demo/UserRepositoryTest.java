package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void findUserByUsernameShouldReturnUser() {
		this.entityManager.persist(new User("test_user", "test_name", "test_surname", "test@test_mail.com"));

		User user = this.userRepo.findUserByUsername("test_user");

		assertThat(user).isNotNull();
		assertThat(user.getUsername()).isEqualTo("test_user");
		assertThat(user.getFirstName()).isEqualTo("test_name");
		assertThat(user.getLastName()).isEqualTo("test_surname");
		assertThat(user.getEmail()).isEqualTo("test@test_mail.com");

	}
}
