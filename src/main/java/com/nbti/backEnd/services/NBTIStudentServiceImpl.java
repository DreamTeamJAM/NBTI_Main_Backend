package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.NBTIStudent;
import com.nbti.backEnd.repositories.NBTIStudentRepository;

@Service
@Transactional
public class NBTIStudentServiceImpl implements NBTIStudentService {

	@Autowired
	NBTIStudentRepository repo;

	@Override
	public void save(NBTIStudent student) {
		repo.save(student);

	}

	@Override
	public List<NBTIStudent> listAll() {

		return repo.findAll();
	}

	@Override
	public Optional<NBTIStudent> findById(String id) {

		return repo.findById(id);
	}

}
