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

import com.nbti.backEnd.model.Company;
import com.nbti.backEnd.services.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService serv;
	
	@PostMapping("/company")
	public ResponseEntity<Long> postStudent(@RequestBody Company company) {
		System.out.println("POST company");
		Long companyId = serv.saveHosting(company);
		return new ResponseEntity<>(companyId, HttpStatus.OK);
	}
	
	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAll(){
		try {
			System.out.println("returning all companies");
			List<Company> enter = serv.findAll();
			

			return new ResponseEntity<>(enter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getById(@PathVariable Long id){
		try {
			System.out.println("returning company " + id);
			Company enter = serv.findById(id).get(); 
			
			

			return new ResponseEntity<>(enter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@DeleteMapping("/company/{id}")
	  public ResponseEntity<String> deleteById(@PathVariable Long id) {
		  
			  return serv.deleteById(id) ? new ResponseEntity<>("deletion succesful", HttpStatus.OK)
						: new ResponseEntity<>(" Id not in DB", HttpStatus.NOT_FOUND);
	  }
	
	@PutMapping("/company")
	 public ResponseEntity<Company> updateCompany(@RequestBody Company company){
	
		try {
			return new ResponseEntity<>(serv.update(company), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		} 
	}
}
