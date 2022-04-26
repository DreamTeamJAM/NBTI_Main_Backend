package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbti.backEnd.model.Company;
import com.nbti.backEnd.repositories.CompanyRepository;



@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository repo;
	@Override
	public Long saveHosting(Company det) {
		
		
		Company save=repo.saveAndFlush(det);
		return save.getId();
	}

	@Override
	public Optional<Company> findById(Long id) {
		
		return repo.findById(id);

	}

	@Override
	public List<Company> findAll() {
	
		return repo.findAll();
	}



	
	
}
