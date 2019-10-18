package com.example.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	private String serviceHost;

	private RestTemplate restTemplate;

	@Autowired
	public UserService(RestTemplate restTemplate, @Value("${user-service.host:user-service}") String sh) {
		this.serviceHost = sh;
		this.restTemplate = restTemplate;
	}

	public User getAuthenticatedUser() {
		URI url = URI.create(String.format("http://%s//uaa/v1/me", serviceHost));

		User user = restTemplate.getForObject(url, User.class);

		return user;
	}
}
