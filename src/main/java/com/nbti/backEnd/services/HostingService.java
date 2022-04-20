package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.HostingDetails;

public interface HostingService {

	Long saveHosting(HostingDetails det);
	
	Optional<HostingDetails> FindById(Long id);
	
	List<HostingDetails> FindAll();
	
}
