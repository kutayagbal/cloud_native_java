package com.example.demo;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	private UserService userService;

	private AuthService authService;

	@Autowired
	public UserController(UserService userService, AuthService authService) {
		this.userService = userService;
		this.authService = authService;
	}

	@GetMapping("/getuser")
	public ResponseEntity<User> getUser(Principal principal) {
		return Optional.ofNullable(authService.getAuthenticatedUser(principal))
				.map(p -> ResponseEntity.ok().body(userService.getUserByPrincipal(p)))
				.orElse(new ResponseEntity<User>(HttpStatus.UNAUTHORIZED));
	}

}
