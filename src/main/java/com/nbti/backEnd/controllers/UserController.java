package com.nbti.backEnd.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	@SuppressWarnings("rawtypes")
	@PostMapping("/signUp")
	public ResponseEntity signUp(@RequestBody Users user) {
		try {
			Long id = userService.signUp(user);
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getClass());
			return new ResponseEntity<>("Username already in use", HttpStatus.FORBIDDEN);
		}

	}

	@GetMapping("/logIn")
	// Limit login tries
	public ResponseEntity<Long> logIn() {
		
		return new ResponseEntity<>(userService.logIn(), HttpStatus.ACCEPTED);

	}

	@GetMapping("/logOut")
	public ResponseEntity<String> logOut() {
		return userService.logOut() ? new ResponseEntity<>("LogOut", HttpStatus.ACCEPTED)
				: new ResponseEntity<>("Log Out failed?", HttpStatus.NOT_ACCEPTABLE);
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
			Users user = userService.checkedFindById(id);

			return new ResponseEntity<>(user, HttpStatus.OK);

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
