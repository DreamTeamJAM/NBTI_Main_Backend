package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.dto.StudentDto;

public interface StudentService {
	
	Student save(Student student);
	
	List<Student> listAll();
	
	StudentDto checkedFindById(Long id);

	void deleteById(Long id);

}
