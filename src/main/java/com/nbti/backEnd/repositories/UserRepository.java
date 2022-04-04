package com.nbti.backEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nbti.backEnd.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
	
	Users findByUsername(String username);
}
