package com.nbti.backEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.services.UserService;

@RestController
public class UserApiController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signUp")
public ResponseEntity<Object> signUp(@RequestBody Users user) {
		
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		userService.signUp(newUser);
		
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
}
