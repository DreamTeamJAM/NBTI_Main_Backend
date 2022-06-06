package com.nbti.backEnd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.User;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByUser(User user);


}
