package com.example.demo;

import java.security.Principal;
import java.util.ArrayList;

import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	public Principal getAuthenticatedUser(Principal principal) {
		if (principal.getName().equals("akif"))
			return new GenericPrincipal(principal.getName(), "admin", new ArrayList<String>()); // dummy principal

		return null;
	}
}
