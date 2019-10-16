package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Ex311RefreshScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex311RefreshScopeApplication.class, args);
	}

}
