package com.security.securitycheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Access {
	@GetMapping("/Alluser")
	public String getName() {
		return "Hello all user";
	}

	@GetMapping("/users")
	public String getuserName() {
		return "Access only for user";
	}

	@GetMapping("/Admin")
	public String getAdminName() {
		return "Hi Admin";
	}
}
