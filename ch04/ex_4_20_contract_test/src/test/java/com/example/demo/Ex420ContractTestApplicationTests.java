package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = { "com.example:ex_4_12-19_contract_test:+:stubs:8081" }, stubsMode = StubsMode.LOCAL)
public class Ex420ContractTestApplicationTests {

	@Autowired
	private UserServiceClient userServiceClient;

	@Test
	public void contractTest() throws Exception {
		ConsumerUser u = userServiceClient.callUserService();

		assertThat(u.getUsername()).matches("[A-Za-z0-9]+");
		assertThat(u.getPassword()).matches("[A-Za-z0-9]+");
		assertThat(u.getEmail()).matches("[A-Za-z0-9]+\\@[A-Za-z0-9]+\\.[A-Za-z]++");
	}

}
