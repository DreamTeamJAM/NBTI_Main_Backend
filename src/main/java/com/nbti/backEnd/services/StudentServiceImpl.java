package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.dto.StudentDto;
import com.nbti.backEnd.model.ERole;
import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.User;
import com.nbti.backEnd.repositories.EducationDetailsRepository;
import com.nbti.backEnd.repositories.JobDetailsRepository;
import com.nbti.backEnd.repositories.LanguageDetailsRepository;
import com.nbti.backEnd.repositories.NBTIFileRepository;
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

	@Autowired
	NBTIFileRepository fileRepo;

	@Override
	public StudentDto save(StudentDto studentDto) {
		System.out.println("saving student ...");

		Student newSt = new Student();

		validateUser(studentDto, newSt);

		setNewDetails(studentDto);

		Reflect.UpdateDates(newSt);
		System.out.println("saved student");
		return new StudentDto(repo.saveAndFlush(newSt));

	}

	private void setNewDetails(StudentDto studentDto) {
		if (studentDto.getOtherLanguages() != null) {
			Reflect.UpdateAllDates(studentDto.getOtherLanguages());
			langRepo.saveAll(studentDto.getOtherLanguages());
		}
		if (studentDto.getWorkExperience() != null) {
			Reflect.UpdateAllDates(studentDto.getWorkExperience());
			jobRepo.saveAll(studentDto.getWorkExperience());
		}
		if (studentDto.getEducation() != null) {
			Reflect.UpdateAllDates(studentDto.getEducation());
			eduRepo.saveAll(studentDto.getEducation());
		}
		if (studentDto.getVolunteering() != null) {
			Reflect.UpdateAllDates(studentDto.getVolunteering());
			volRepo.saveAll(studentDto.getVolunteering());
		}
	}

	private void validateUser(StudentDto student, Student newSt) {
		if (student.getUserId() == null) {
			User user = userRepo.findByUsername(AuthUtils.getUsername()).get();
			if (user.getRoles().stream().anyMatch((r) -> r.getName().equals(ERole.ROLE_ADMIN))) {
				newSt.setUser(user);
			}
			if (repo.findAll().stream().anyMatch(st -> st.getUser().equals(user)))
				throw new NoSuchElementException("cant post more than 1 student per user");// More descriptive
																							// exceptions

		}
		System.out.println(" related user verified");
	}

	@Override
	public StudentDto update(StudentDto dto) {

		Student updatingSt = checkedFindById(dto.getId());
		clearOldDetails(updatingSt);
		setNewDetails(dto);
		Student updatedSt = new Student(dto, fileRepo.findById(dto.getPhotoId()).get(),
				fileRepo.findById(dto.getDniFrontId()).get(), fileRepo.findById(dto.getDniBackId()).get(),
				userRepo.findById(dto.getUserId()).get());

		Reflect.updateObject(updatingSt, updatedSt);
		Reflect.UpdateDates(updatingSt);
		repo.saveAndFlush(updatingSt);

		return new StudentDto(updatingSt);
	}

	private void clearOldDetails(Student studentDto) {

		if (studentDto.getOtherLanguages() != null) {
			langRepo.deleteAll(studentDto.getOtherLanguages());
		}
		if (studentDto.getWorkExperience() != null) {
			jobRepo.deleteAll(studentDto.getWorkExperience());
		}
		if (studentDto.getEducation() != null) {
			eduRepo.deleteAll(studentDto.getEducation());
		}
		if (studentDto.getVolunteering() != null) {
			volRepo.deleteAll(studentDto.getVolunteering());
		}

	}

	@Override
	public List<StudentDto> listAll() {

		return repo.findAll().stream().map((s -> new StudentDto(s))).collect(Collectors.toList());
	}

	public Student checkedFindById(Long id) {
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
	public StudentDto checkedFindDtoById(Long id) {
		StudentDto dto = new StudentDto(checkedFindById(id));
		return dto;
	}
}
