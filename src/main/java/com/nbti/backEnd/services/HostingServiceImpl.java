package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbti.backEnd.model.Hosting;
import com.nbti.backEnd.repositories.HostingRepository;



@Service
public class HostingServiceImpl implements HostingService {

	@Autowired
	HostingRepository repo;
	@Override
	public Long saveHosting(Hosting det) {
		
		
		Hosting save=repo.saveAndFlush(det);
		return save.getId();
	}

	@Override
	public Optional<Hosting> FindById(Long id) {
		
		return repo.findById(id);

	}

	@Override
	public List<Hosting> FindAll() {
	
		return repo.findAll();
	}



	
	
}
