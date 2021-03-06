package com.nbti.backEnd.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbti.backEnd.dto.StudentDto;
import com.nbti.backEnd.services.StudentService;

@RestController
public class StudentController {

	private static final String DELETION_EXIT_STR = "Deletion Successful";
	private static final String NULL_ID_STR = "No valid id provided";
	private static final String NOT_FOUND_STR = "No student found with that Id";
	@Autowired
	private StudentService studentService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/student")
	public ResponseEntity postStudent(@RequestBody StudentDto student) {
		if (student.getId() != null) {
			System.out.println("detected ID: redirecting to put");
			return updateStudent(student);
		}
		System.out.println("POST Student");
		StudentDto savedStudent = studentService.save(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@GetMapping("/student")
	public ResponseEntity<List<StudentDto>> getAll() {
		try {
			System.out.println("returning all students");
			List<StudentDto> students = studentService.listAll();

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/student/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		try {
			System.out.println("returning student with id " + id);
			StudentDto student = studentService.checkedFindDtoById(id);

			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(NOT_FOUND_STR, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/users/{id}/student")
	public ResponseEntity getByUserId(@PathVariable Long id) {
		try {
			System.out.println("returning student with user with id: " + id);
			StudentDto student = studentService.checkedFindByUser(id);

			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(NOT_FOUND_STR, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/student")
	public ResponseEntity updateStudent(@RequestBody StudentDto student) {
		try {
			System.out.println("updating student with id " + student.getId());
//			studentService.checkedFindById(student.getId());

			return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(NOT_FOUND_STR, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			System.out.println("deleting student with id " + id);
			studentService.deleteById(id);
			return new ResponseEntity<>(DELETION_EXIT_STR, HttpStatus.ACCEPTED);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(NULL_ID_STR, HttpStatus.BAD_REQUEST);
		}

	}

}
