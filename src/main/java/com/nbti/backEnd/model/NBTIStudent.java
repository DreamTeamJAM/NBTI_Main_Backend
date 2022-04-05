package com.nbti.backEnd.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "NBTIStudent")
public class NBTIStudent {

	@Id
	private String id;

	@Field
	private Long photo;

	@Field
	private String name;

	@Field
	private String firstSurname;

	@Field
	private String secondSurname;

	@Field
	private String nationality;

	@Field
	private String phone;

	@Field
	private Date birthDate;

	@Field
	private String gender;// Enum maybe?

	@Field
	private String email;

	@Field
	private Long dniFront; // Base64

	@Field
	private Long dniBack; // Base64

	@Field
	private String adress;

	@Field
	private String aboutMe;

	@Field
	private List<JobDetails> workExperience;

	@Field
	private List<EducationDetails> education;

	@Field
	private List<String> motherTongues;

	@Field
	private List<LanguageDetails> otherLanguages;

	@Field
	private List<String> digitalSkills;

	@Field
	private List<String> comunicationSkills;

	@Field
	private String drivingLicense;// could be bool

	@Field
	private List<String> hobbies;

	@Field
	private List<VolunteerDetails> volunteering;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPhoto() {
		return photo;
	}

	public void setPhoto(Long photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getDniFront() {
		return dniFront;
	}

	public void setDniFront(Long dniFront) {
		this.dniFront = dniFront;
	}

	public Long getDniBack() {
		return dniBack;
	}

	public void setDniBack(Long dniBack) {
		this.dniBack = dniBack;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public void setWorkExperience(List<JobDetails> workExperiences) {
		this.workExperience = workExperiences;
	}

	public List<EducationDetails> getEducation() {
		return education;
	}

	public void setEducation(List<EducationDetails> education) {
		this.education = education;
	}

	public List<String> getMotherTongues() {
		return motherTongues;
	}

	public void setMotherTongues(List<String> motherTongues) {
		this.motherTongues = motherTongues;
	}

	public List<LanguageDetails> getOtherLanguages() {
		return otherLanguages;
	}

	public void setOtherLanguages(List<LanguageDetails> otherLanguages) {
		this.otherLanguages = otherLanguages;
	}

	public List<String> getDigitalSkills() {
		return digitalSkills;
	}

	public void setDigitalSkills(List<String> digitalSkills) {
		this.digitalSkills = digitalSkills;
	}

	public List<String> getComunicationSkills() {
		return comunicationSkills;
	}

	public void setComunicationSkills(List<String> comunicationSkills) {
		this.comunicationSkills = comunicationSkills;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<VolunteerDetails> getVolunteering() {
		return volunteering;
	}

	public void setVolunteering(List<VolunteerDetails> volunteering) {
		this.volunteering = volunteering;
	}

}
