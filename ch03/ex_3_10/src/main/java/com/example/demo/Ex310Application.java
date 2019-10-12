package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@SpringBootApplication
public class Ex310Application {
	
	private final Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Ex310Application.class, args);
	}
	
	@Autowired
	public Ex310Application(ConfigurationProjectProperties cp) {
		log.info("### configurationProjectProperties.projectName = " + cp.getProjectName());
	}

}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
	private String projectName;

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}