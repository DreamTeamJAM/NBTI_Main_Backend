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

import com.nbti.backEnd.model.EnterpriseDetails;
import com.nbti.backEnd.services.EnterpriseService;

@RestController
public class EnterpriseController {

	@Autowired
	EnterpriseService serv;
	
	@PostMapping("/enterprise")
	public ResponseEntity<Long> postStudent(@RequestBody EnterpriseDetails enter) {
		System.out.println("POST Enterprise");
		Long identer = serv.saveHosting(enter);
		return new ResponseEntity<>(identer, HttpStatus.OK);
	}
	
	@GetMapping("/enterprise")
	public ResponseEntity<List<EnterpriseDetails>> getAll(){
		try {
			System.out.println("returning all Enterprises");
			List<EnterpriseDetails> enter = serv.FindAll();
			

			return new ResponseEntity<>(enter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/enterprise/{id}")
	public ResponseEntity<EnterpriseDetails> getById(@PathVariable Long id){
		try {
			System.out.println("returning Enterprise " + id);
			EnterpriseDetails enter = serv.FindById(id).get(); 
			
			

			return new ResponseEntity<>(enter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
}
