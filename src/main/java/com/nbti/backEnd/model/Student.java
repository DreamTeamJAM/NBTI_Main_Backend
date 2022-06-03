package com.nbti.backEnd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nbti.backEnd.dto.StudentDto;

@Entity
@Table(name = "STUDENT")
public class Student extends NbtiEntity implements Payee {

	@OneToOne
	@JoinColumn(name = "photo_id")
	private NBTIFile photo;

	private String name;

	private String dni;

	private String city;

	private String typeOfStudent;// enum?

	private enum MobilityStatus{
		PENDING, ACCEPTED, DENIED, IN_PROGRESS, COMPLETED, CANCELLED
	}
	
	private MobilityStatus mobilityStatus;
	
	@OneToOne
	@JoinColumn(name = "school_id")
	private EducationDetails currentSchool;

	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference(value="studentUser")
	private User user;

	@ManyToOne
	@JoinColumn(name = "current_company_id")
	@JsonBackReference(value="studentCompany")
	private Company currentCompany;

	@ManyToOne
	@JoinColumn(name = "current_hosting_id")
	@JsonBackReference(value="studentHosting")
	private Hosting currentHosting;

	@OneToMany(mappedBy = "payedStudent")
	@JsonManagedReference(value="studentPayments")
	private List<StudentPayment> payments;

	private String project;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date countryArrival;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date countryDeparture;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hostelArrival;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hostelDeparture;

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

	public Student() {
		
	}

	public Student(StudentDto dto, NBTIFile photo, NBTIFile dniFront,
			NBTIFile dniBack, User user) {
		
		super();
		this.photo = photo;
		this.name = dto.getName();
		this.dni = dto.getDni();
		this.city = dto.getCity();
		this.user = user;
		this.firstSurname = dto.getFirstSurname();
		this.secondSurname = dto.getSecondSurname();
		this.nationality = dto.getNationality();
		this.phone = dto.getPhone();
		this.birthDate = dto.getBirthDate();
		this.gender = dto.getGender();
		this.email = dto.getEmail();
		this.dniFront = dniFront;
		this.dniBack = dniBack;
		this.address = dto.getAddress();
		this.aboutMe = dto.getAboutMe();
		this.workExperience = dto.getWorkExperience();
		this.education = dto.getEducation();
		this.motherTongues = dto.getMotherTongues();
		this.otherLanguages = dto.getOtherLanguages();
		this.digitalSkills = dto.getDigitalSkills();
		this.comunicationSkills = dto.getComunicationSkills();
		this.drivingLicense = dto.getDrivingLicense();
		this.hobbies = dto.getHobbies();
		this.volunteering = dto.getVolunteering();
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
	
	

	public MobilityStatus getMobilityStatus() {
		return mobilityStatus;
	}

	public void setMobilityStatus(MobilityStatus mobilityStatus) {
		this.mobilityStatus = mobilityStatus;
	}

	public List<JobDetails> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<JobDetails> workExperiences) {
		this.workExperience.clear();
		if (workExperiences != null)
			this.workExperience.addAll(workExperiences);
	}

	public List<EducationDetails> getEducation() {
		return education;
	}

	public void setEducation(List<EducationDetails> education) {
		this.education.clear();
		if (education != null)
			this.education.addAll(education);
	}

	public List<LanguageDetails> getOtherLanguages() {
		return otherLanguages;
	}

	public void setOtherLanguages(List<LanguageDetails> otherLanguages) {
		this.otherLanguages.clear();
		if (otherLanguages != null)
			this.otherLanguages.addAll(otherLanguages);
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
		this.volunteering.clear();
		if (volunteering != null)
			this.volunteering.addAll(volunteering);
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

	public Date getCountryArrival() {
		return countryArrival;
	}

	public void setCountryArrival(Date arrival) {
		this.countryArrival = arrival;
	}

	public Date getCountryDeparture() {
		return countryDeparture;
	}

	public void setCountryDeparture(Date departure) {
		this.countryDeparture = departure;
	}

	public Date getHostelArrival() {
		return hostelArrival;
	}

	public void setHostelArrival(Date hostelArrival) {
		this.hostelArrival = hostelArrival;
	}

	public Date getHostelDeparture() {
		return hostelDeparture;
	}

	public void setHostelDeparture(Date hostelDeparture) {
		this.hostelDeparture = hostelDeparture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<StudentPayment> getPayments() {
		return payments;
	}

	public void setPayments(List<StudentPayment> payments) {
		this.payments = payments;
	}

}
