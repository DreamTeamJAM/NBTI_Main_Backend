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

import com.nbti.backEnd.model.Hosting;
import com.nbti.backEnd.services.HostingService;

@RestController
public class HostingController {

	@Autowired
	HostingService serv;
	
	@PostMapping("/hosting")
	public ResponseEntity<Long> postStudent(@RequestBody Hosting host) {
		System.out.println("POST Hosting");
		Long idHosting = serv.saveHosting(host);
		return new ResponseEntity<>(idHosting, HttpStatus.OK);
	}
	
	@GetMapping("/hosting")
	public ResponseEntity<List<Hosting>> getAll(){
		try {
			System.out.println("returning all Hostings");
			List<Hosting> hosts = serv.FindAll();
			

			return new ResponseEntity<>(hosts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/hosting/{id}")
	public ResponseEntity<Hosting> getById(@PathVariable Long id){
		try {
			System.out.println("returning Hosting " + id);
			Hosting host = serv.FindById(id).get(); 
			
			

			return new ResponseEntity<>(host, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
}
