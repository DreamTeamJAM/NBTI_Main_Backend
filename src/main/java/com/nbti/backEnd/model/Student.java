package com.nbti.backEnd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "photo_id")
	private NBTIFile photo;

	private String name;

	private String dni;

	private String city;

	private String typeOfStudent;// enum?

	@OneToOne
	@JoinColumn(name = "school_id")
	private EducationDetails currentSchool;

	@ManyToOne
	@JoinColumn(name = "current_company_id")
	private Company currentCompany;

	@ManyToOne
	@JoinColumn(name = "current_hosting_id")
	private Hosting currentHosting;

	private String project;

	private Date arrival;

	private Date departure;

	private String firstSurname;

	private String secondSurname;

	private String nationality;

	private String phone;

	private Date birthDate;

	private String gender;// Enum maybe?

	private String email;

	@OneToOne
	@JoinColumn(name = "dni_front_id")
	private NBTIFile dniFront;

	@OneToOne
	@JoinColumn(name = "dni_back_id")
	private NBTIFile dniBack;

	private String address;

	private String aboutMe;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<JobDetails> workExperience;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<EducationDetails> education;

	private String motherTongues;// Json

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<LanguageDetails> otherLanguages;

	private String digitalSkills;// Json

	private String comunicationSkills;// Json

	public enum DrivingLicenseType {
		AM, A1, A2, A, B, BE, W, C, CE, C1, C1E, D, DE, D1, D1E
	}

	private DrivingLicenseType drivingLicense;

	private String hobbies;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<VolunteerDetails> volunteering;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NBTIFile getPhoto() {
		return photo;
	}

	public void setPhoto(NBTIFile photo) {
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

	public NBTIFile getDniFront() {
		return dniFront;
	}

	public void setDniFront(NBTIFile dniFront) {
		this.dniFront = dniFront;
	}

	public NBTIFile getDniBack() {
		return dniBack;
	}

	public void setDniBack(NBTIFile dniBack) {
		this.dniBack = dniBack;
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

	public void setWorkExperience(List<JobDetails> workExperiences) {
		this.workExperience = workExperiences;
	}

	public List<EducationDetails> getEducation() {
		return education;
	}

	public void setEducation(List<EducationDetails> education) {
		this.education = education;
	}

	public List<LanguageDetails> getOtherLanguages() {
		return otherLanguages;
	}

	public void setOtherLanguages(List<LanguageDetails> otherLanguages) {
		this.otherLanguages = otherLanguages;
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

	public String getMotherTongues() {
		return motherTongues;
	}

	public void setMotherTongues(String motherTongues) {
		this.motherTongues = motherTongues;
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

	public String getTypeOfStudent() {
		return typeOfStudent;
	}

	public void setTypeOfStudent(String typeOfStudent) {
		this.typeOfStudent = typeOfStudent;
	}

	public EducationDetails getCurrentSchool() {
		return currentSchool;
	}

	public void setCurrentSchool(EducationDetails currentSchool) {
		this.currentSchool = currentSchool;
	}

	public Company getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}

	public Hosting getCurrentHosting() {
		return currentHosting;
	}

	public void setCurrentHosting(Hosting currentHosting) {
		this.currentHosting = currentHosting;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

}
