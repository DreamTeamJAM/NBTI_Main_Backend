package com.nbti.backEnd.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signUp")
	public ResponseEntity<Long> signUp(@RequestBody Users user) {

		Long id = userService.signUp(user);

		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@GetMapping("/logIn/{username}/{password}")
	public ResponseEntity<String> logIn(@PathVariable String username, @PathVariable String password) {
		return userService.logIn(username, password) ? new ResponseEntity<>("Login succesful", HttpStatus.ACCEPTED)
				: new ResponseEntity<>("Login failed", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/users")
	public ResponseEntity<List<Users>> getUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

	}

	@PutMapping("/users")
	public ResponseEntity<Users> putUser(@RequestBody Users user) {
		try {
			return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Long id) {

		try {
			return new ResponseEntity<>(userService.findById(id).get(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {

		return userService.deleteById(id) ? new ResponseEntity<>("deletion succesful", HttpStatus.OK)
				: new ResponseEntity<>(" Id not in DB", HttpStatus.NOT_FOUND);

	}

}
