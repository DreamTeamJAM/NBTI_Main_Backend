package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbti.backEnd.model.HostingDetails;
import com.nbti.backEnd.repositories.HostingDetailsRepository;



@Service
public class HostingServiceImpl implements HostingService {

	@Autowired
	HostingDetailsRepository repo;
	@Override
	public Long saveHosting(HostingDetails det) {
		
		
		HostingDetails save=repo.saveAndFlush(det);
		return save.getId();
	}

	@Override
	public Optional<HostingDetails> FindById(Long id) {
		
		return repo.findById(id);

	}

	@Override
	public List<HostingDetails> FindAll() {
	
		return repo.findAll();
	}



	
	
}
