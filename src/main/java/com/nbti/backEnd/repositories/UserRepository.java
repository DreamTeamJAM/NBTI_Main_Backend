package com.nbti.backEnd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbti.backEnd.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	List<Users> findByUsername(String username);
}
