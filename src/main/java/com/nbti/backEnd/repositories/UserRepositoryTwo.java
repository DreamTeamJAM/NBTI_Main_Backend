package com.nbti.backEnd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.Users;

public interface UserRepositoryTwo extends JpaRepository<Users, Long> {
	List<Users> findByUsername(String username);
}
