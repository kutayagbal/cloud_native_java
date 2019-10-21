package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AccountServiceTest.class, UserTests.class })
@SpringBootTest
public class Ex43MockIntegrationTestApplicationTests {
	
//	@Test
//	public void contextLoads() {
//	}
}
