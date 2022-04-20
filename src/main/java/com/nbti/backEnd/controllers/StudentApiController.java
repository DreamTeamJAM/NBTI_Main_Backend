package com.nbti.backEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbti.backEnd.model.NBTIStudent;
import com.nbti.backEnd.services.NBTIStudentService;

@RestController
public class StudentApiController {

	@Autowired
	private NBTIStudentService studentService;

	@PostMapping("/nbtiCV")
	public ResponseEntity<Long> postStudent(@RequestBody NBTIStudent student) {
		System.out.println("POST Student CV");
		NBTIStudent savedCV = studentService.save(student);
		return new ResponseEntity<>(savedCV.getId(), HttpStatus.OK);
	}

	@GetMapping("/nbtiCV")
	public ResponseEntity<List<NBTIStudent>> getAll() {
		try {
			System.out.println("returning all pdfs");
			List<NBTIStudent> students = studentService.listAll();

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/nbtiCV/{id}")
	public ResponseEntity<NBTIStudent> getById(@PathVariable Long id) {
		try {
			System.out.println("returning cv with id " + id);
			NBTIStudent student = studentService.findById(id).get();

			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
