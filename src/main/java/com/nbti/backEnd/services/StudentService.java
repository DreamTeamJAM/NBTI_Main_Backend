package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.dto.StudentDto;

public interface StudentService {
	
	StudentDto save(StudentDto student);
	
	List<StudentDto> listAll();
	
	StudentDto checkedFindDtoById(Long id);

	void deleteById(Long id);

	StudentDto update(StudentDto dto);

}
