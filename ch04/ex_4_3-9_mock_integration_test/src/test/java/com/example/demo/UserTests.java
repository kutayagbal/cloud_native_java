package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class UserTests {
	private User user;

	@Autowired
	private JacksonTester<User> json;

	@Before
	public void setUp() throws Exception {
		User user = new User(0L, "Akif", 123456L);
		this.user = user;
	}

	@Test
	public void deserializeJson() throws Exception {
		String content = "{\"name\":\"Akif\", \"userId\":0, \"accountId\":123456}";
		
		assertThat(this.json.parse(content)).isEqualToComparingFieldByFieldRecursively(new User(0L, "Akif", 123456L));
		assertThat(this.json.parseObject(content).getName()).isEqualTo("Akif");
	}
	
	@Test
	public void serializeJson() throws Exception{
		assertThat(this.json.write(user)).isEqualTo("user.json");
		assertThat(this.json.write(user)).isEqualToJson("user.json");
		assertThat(this.json.write(user)).hasJsonPathStringValue("@.name");
		
		assertThat(this.json.write(user)).extractingJsonPathNumberValue("@.userId").isEqualTo(0);
		assertThat(this.json.write(user)).extractingJsonPathNumberValue("@.accountId").isEqualTo(123456);
	}
}
