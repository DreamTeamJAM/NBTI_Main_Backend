package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.repositories.EducationDetailsRepository;
import com.nbti.backEnd.repositories.JobDetailsRepository;
import com.nbti.backEnd.repositories.LanguageDetailsRepository;
import com.nbti.backEnd.repositories.StudentRepository;
import com.nbti.backEnd.repositories.VolunteerDetailsRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@Autowired
	JobDetailsRepository jobRepo;

	@Autowired
	VolunteerDetailsRepository volRepo;

	@Autowired
	EducationDetailsRepository eduRepo;

	@Autowired
	LanguageDetailsRepository langRepo;

	@Override
	public Student save(Student student) {
		if (student.getOtherLanguages() != null)
			langRepo.saveAll(student.getOtherLanguages());
		if (student.getWorkExperience() != null)
			jobRepo.saveAll(student.getWorkExperience());
		if (student.getEducation() != null)
			eduRepo.saveAll(student.getEducation());
		if (student.getVolunteering() != null)
			volRepo.saveAll(student.getVolunteering());
		return repo.saveAndFlush(student);

	}

	@Override
	public List<Student> listAll() {

		return repo.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {

		return repo.findById(id);
	}

}
