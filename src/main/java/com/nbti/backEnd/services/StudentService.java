package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Student;

public interface StudentService {
	
	Student save(Student student);
	
	List<Student> listAll();
	
	Optional<Student> findById(Long id);

}
