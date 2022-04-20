package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.EnterpriseDetails;

public interface EnterpriseService {

	Long saveHosting(EnterpriseDetails det);
	
	Optional<EnterpriseDetails> FindById(Long id);
	
	List<EnterpriseDetails> FindAll();
	
}
