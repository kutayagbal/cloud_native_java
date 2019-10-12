package com.example.demo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@SpringBootApplication
public class Ex37Application {

	private final Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Ex37Application.class, args);
	}

	@Autowired
	public Ex37Application(ConfigurationProjectProperties cp) {
		log.info("configurationProjectProperties.projectName = " + cp.getProjectName() + " ownerName = " + cp.getOwnerName());
	}
}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
	private String projectName;
	private String ownerName;

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
