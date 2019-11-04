package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UserControllerTest.class, UserRepositoryTest.class, UserServiceTest.class })
@SpringBootTest
public class UserTests {

}
