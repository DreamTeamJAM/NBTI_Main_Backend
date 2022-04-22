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

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/nbtiCV")
	public ResponseEntity<Long> postStudent(@RequestBody Student student) {
		System.out.println("POST Student CV");
		Student savedCV = studentService.save(student);
		return new ResponseEntity<>(savedCV.getId(), HttpStatus.OK);
	}

	@GetMapping("/nbtiCV")
	public ResponseEntity<List<Student>> getAll() {
		try {
			System.out.println("returning all pdfs");
			List<Student> students = studentService.listAll();

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/nbtiCV/{id}")
	public ResponseEntity<Student> getById(@PathVariable Long id) {
		try {
			System.out.println("returning cv with id " + id);
			Student student = studentService.findById(id).get();

			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
