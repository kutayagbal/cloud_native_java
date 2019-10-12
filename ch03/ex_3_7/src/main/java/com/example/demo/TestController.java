package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	Log log = LogFactory.getLog(getClass()); 

	@GetMapping("/test")
	public void getTest() {
		log.info("### test service called!");
	}
}
