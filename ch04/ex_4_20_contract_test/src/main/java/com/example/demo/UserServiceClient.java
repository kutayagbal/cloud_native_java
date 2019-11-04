package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {

	public ConsumerUser callUserService() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<ConsumerUser> result = restTemplate.exchange("http://localhost:8081/user/getuser",
				HttpMethod.GET, new HttpEntity<Object>(httpHeaders), ConsumerUser.class);

		return result.getBody();
	}
}
