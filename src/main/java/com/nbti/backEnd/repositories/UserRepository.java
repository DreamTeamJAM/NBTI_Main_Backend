package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbti.backEnd.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
	
	Users findByUsername(String username);
}
