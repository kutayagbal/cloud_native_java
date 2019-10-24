package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accService) {
		this.accountService = accService;
	}

	@GetMapping("/user_account")
	public Optional<Account> getUserAccount(Long userId) {
		return accountService.getUserAccount();
	}
}
