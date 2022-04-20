package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbti.backEnd.model.EnterpriseDetails;
import com.nbti.backEnd.repositories.EnterpriseDetailsRepository;



@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	EnterpriseDetailsRepository repo;
	@Override
	public Long saveHosting(EnterpriseDetails det) {
		
		
		EnterpriseDetails save=repo.saveAndFlush(det);
		return save.getId();
	}

	@Override
	public Optional<EnterpriseDetails> FindById(Long id) {
		
		return repo.findById(id);

	}

	@Override
	public List<EnterpriseDetails> FindAll() {
	
		return repo.findAll();
	}



	
	
}
