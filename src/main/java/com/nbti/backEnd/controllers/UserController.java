package com.nbti.backEnd.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbti.backEnd.model.User;
import com.nbti.backEnd.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

	}

	@PutMapping("/users")
	public ResponseEntity<User> putUser(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {

		try {
			User user = userService.checkedFindById(id);

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
