package com.example.demo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	private final AccountRepository accRepo;
	private final UserService userService;

	@Autowired
	public AccountService(AccountRepository accRepo, UserService userService) {
		this.accRepo = accRepo;
		this.userService = userService;
	}

	public Optional<Account> getUserAccount() {
		return Optional.ofNullable(userService.getAuthenticatedUser()).map(u -> accRepo.findById(u.getAccountId()))
				.orElse(null);
	}

	public List<Account> getUserAccounts() {
		return Optional.ofNullable(userService.getAuthenticatedUser())
				.map(u -> accRepo.findAccountsByUsername(u.getName())).orElse(Collections.emptyList());
	}
}
