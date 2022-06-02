package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbti.backEnd.model.Company;
import com.nbti.backEnd.repositories.CompanyRepository;
import com.nbti.backEnd.utils.Reflect;



@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository repo;
	@Override
	public Long saveHosting(Company det) {
		
		Reflect.UpdateDates(det);
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

	@Override
	public Boolean deleteById(Long id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}
	
	@Override
	public Company update(Company updatedCompany) throws NoSuchElementException, IllegalArgumentException {
		Long id = updatedCompany.getId();
		if (id == null) throw new IllegalArgumentException("Id must not be null");
		Company updatingCompany = findById(id).get();
		Reflect.updateObject(updatingCompany, updatedCompany);
		Reflect.UpdateDates(updatingCompany);
		return repo.saveAndFlush(updatingCompany);
	}

	
	
}
