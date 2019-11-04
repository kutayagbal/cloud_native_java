package com.example.demo;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User getUserByPrincipal(Principal principal) {
		return Optional.ofNullable(principal).map(p -> userRepo.findUserByUsername(p.getName())).orElse(null);
	}
}
