package com.nbti.backEnd.services;

import java.util.List;

import com.nbti.backEnd.model.NBTIStudent;

public interface NBTIStudentService {
	
	void save(NBTIStudent student);
	
	List<NBTIStudent> listAll();

}
