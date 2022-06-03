package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.dto.StudentDto;
import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.User;
import com.nbti.backEnd.repositories.EducationDetailsRepository;
import com.nbti.backEnd.repositories.JobDetailsRepository;
import com.nbti.backEnd.repositories.LanguageDetailsRepository;
import com.nbti.backEnd.repositories.StudentRepository;
import com.nbti.backEnd.repositories.UserRepository;
import com.nbti.backEnd.repositories.VolunteerDetailsRepository;
import com.nbti.backEnd.utils.AuthUtils;
import com.nbti.backEnd.utils.Reflect;

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

	@Autowired
	UserRepository userRepo;

	@Override
	public Student save(Student student) {
		
		System.out.println("saving student ...");
			if (student.getUser() == null) {
				User user = userRepo.findByUsername(AuthUtils.getUsername()).get();
//				if (user.getRoles().stream().anyMatch((r) -> r.getName().equals(ERole.ROLE_ADMIN)))
					if (repo.findAll().stream().anyMatch(st -> st.getUser().equals(user)))
						throw new NoSuchElementException();// More descriptive exceptions
				
				student.setUser(user);
		}
		System.out.println(" related user verified");
		if (student.getOtherLanguages() != null) {
			Reflect.UpdateAllDates(student.getOtherLanguages());
			langRepo.saveAll(student.getOtherLanguages());
		}
		if (student.getWorkExperience() != null) {
			Reflect.UpdateAllDates(student.getWorkExperience());
			jobRepo.saveAll(student.getWorkExperience());
		}
		if (student.getEducation() != null) {
			Reflect.UpdateAllDates(student.getEducation());
			eduRepo.saveAll(student.getEducation());
		}
		if (student.getVolunteering() != null) {
			Reflect.UpdateAllDates(student.getVolunteering());
			volRepo.saveAll(student.getVolunteering());
		}
		Reflect.UpdateDates(student);
		System.out.println("saved student");
		return repo.saveAndFlush(student);

	}

	@Override
	public List<Student> listAll() {

		return repo.findAll();
	}

	
    @Deprecated
	public Student checkedFindByIdOld(Long id) {
		Student student = repo.findById(id).get();
		if (student.getUser() == null)
			throw new NoSuchElementException();
		AuthUtils.authUser(student.getUser());
		return student;
	}

	@Override
	public void deleteById(Long id) {

		repo.deleteById(id);
	}
	@Override
	public StudentDto checkedFindById(Long id) {
		Student student = repo.findById(id).get();
		StudentDto dto = new StudentDto(student);
		if (student.getUser() == null)
			throw new NoSuchElementException();
		AuthUtils.authUser(student.getUser());
		return dto;
	}
}
