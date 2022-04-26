package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Hosting;

public interface HostingService {

	Long saveHosting(Hosting det);
	
	Optional<Hosting> findById(Long id);
	
	List<Hosting> findAll();
	
	Boolean deleteById(Long id);
	
	Hosting update(Hosting host);
	
}
