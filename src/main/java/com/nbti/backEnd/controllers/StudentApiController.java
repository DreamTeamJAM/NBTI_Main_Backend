package com.nbti.backEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public void postStudent(@RequestBody NBTIStudent student) {
		System.out.println(student.getWorkExperience().get(0).getTitle());
		studentService.save(student);
	}
	
	@GetMapping("nbtiCV")
	public ResponseEntity<List<NBTIStudent>> getAll(){
		try {
			System.out.println("returning all pdfs");
			List<NBTIStudent> pdfs = studentService.listAll();
			

			return new ResponseEntity<>(pdfs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
