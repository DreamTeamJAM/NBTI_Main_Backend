package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Company;

public interface CompanyService {

	Long saveHosting(Company det);
	
	Optional<Company> findById(Long id);
	
	List<Company> findAll();
	
    Boolean deleteById(Long id);
	
	Company update(Company company);
}
