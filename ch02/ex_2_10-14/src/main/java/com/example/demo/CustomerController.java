package com.example.demo;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public Collection<Customer> realAll() {
		return this.customerService.findAll();
	}
	
	@GetMapping("/insert")
	public void insert() {
		this.customerService.insertCustomers();
	}
}
