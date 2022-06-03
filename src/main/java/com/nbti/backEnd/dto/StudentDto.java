package com.nbti.backEnd.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nbti.backEnd.model.EducationDetails;
import com.nbti.backEnd.model.JobDetails;
import com.nbti.backEnd.model.LanguageDetails;
import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.Student.DrivingLicenseType;
import com.nbti.backEnd.model.VolunteerDetails;

public class StudentDto {

	private Long id;
	private Long userId;
	private Long photoId;
	private Long dniFrontId;
	private Long dniBackId;
	private String name;
	private String dni;
	private String city;
	private String firstSurname;
	private String secondSurname;
	private String nationality;
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String gender;
	private String email;
	private String address;
	private String aboutMe;
	private List<JobDetails> workExperience;
	private List<EducationDetails> education;
	private String motherTongues;
	private List<LanguageDetails> otherLanguages;
	private String digitalSkills;
	private String comunicationSkills;
	private DrivingLicenseType drivingLicense;
	private String hobbies;
	private List<VolunteerDetails> volunteering;

	public StudentDto() {
		
	}
	
	public StudentDto(Student s) {
		id = s.getId();
		name= s.getName();
		if(s.getUser()!=null) {
			userId= s.getUser().getId();
		}
		if(s.getPhoto()!=null) {
			photoId= s.getPhoto().getId();
		}
		if(s.getDniFront()!=null) {
			dniFrontId= s.getDniFront().getId();
		}
		if(s.getDniBack()!=null) {
			dniBackId= s.getDniBack().getId();
		}
		dni= s.getDni();
		city= s.getCity();
		firstSurname= s.getFirstSurname();
		secondSurname= s.getSecondSurname();
		nationality= s.getNationality();
		phone= s.getPhone();
		birthDate= s.getBirthDate();
		gender= s.getGender();
		email= s.getEmail();
		address= s.getAddress();
		aboutMe= s.getAboutMe();
		workExperience= s.getWorkExperience();
		education= s.getEducation();
		motherTongues= s.getMotherTongues();
		otherLanguages= s.getOtherLanguages();
		digitalSkills= s.getDigitalSkills();
		comunicationSkills= s.getComunicationSkills();
		drivingLicense= s.getDrivingLicense();
		hobbies= s.getHobbies();
		volunteering= s.getVolunteering();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public List<JobDetails> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<JobDetails> workExperience) {
		this.workExperience = workExperience;
	}

	public List<EducationDetails> getEducation() {
		return education;
	}

	public void setEducation(List<EducationDetails> education) {
		this.education = education;
	}

	public String getMotherTongues() {
		return motherTongues;
	}

	public void setMotherTongues(String motherTongues) {
		this.motherTongues = motherTongues;
	}

	public List<LanguageDetails> getOtherLanguages() {
		return otherLanguages;
	}

	public void setOtherLanguages(List<LanguageDetails> otherLanguages) {
		this.otherLanguages = otherLanguages;
	}

	public String getDigitalSkills() {
		return digitalSkills;
	}

	public void setDigitalSkills(String digitalSkills) {
		this.digitalSkills = digitalSkills;
	}

	public String getComunicationSkills() {
		return comunicationSkills;
	}

	public void setComunicationSkills(String comunicationSkills) {
		this.comunicationSkills = comunicationSkills;
	}

	public DrivingLicenseType getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(DrivingLicenseType drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public List<VolunteerDetails> getVolunteering() {
		return volunteering;
	}

	public void setVolunteering(List<VolunteerDetails> volunteering) {
		this.volunteering = volunteering;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public Long getDniFrontId() {
		return dniFrontId;
	}

	public void setDniFrontId(Long dniFrontId) {
		this.dniFrontId = dniFrontId;
	}

	public Long getDniBackId() {
		return dniBackId;
	}

	public void setDniBackId(Long dniBackId) {
		this.dniBackId = dniBackId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
