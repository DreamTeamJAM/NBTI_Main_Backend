package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;
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
	public Optional<Hosting> findById(Long id) {
		
		return repo.findById(id);

	}

	@Override
	public List<Hosting> findAll() {
	
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
	public Hosting update(Hosting host) throws NoSuchElementException {

		findById(host.getId()).get();
		return repo.saveAndFlush(host);
	}

	
	
}
