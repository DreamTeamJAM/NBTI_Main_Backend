package com.nbti.backEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nbti.backEnd.model.NBTIStudent;

public interface NBTIStudentRepository extends MongoRepository<NBTIStudent, String>{

}
