package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.NBTIStudent;

public interface NBTIStudentService {
	
	void save(NBTIStudent student);
	
	List<NBTIStudent> listAll();
	
	Optional<NBTIStudent> findById(String id);

}
