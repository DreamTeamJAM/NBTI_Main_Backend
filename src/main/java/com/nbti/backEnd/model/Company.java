package com.nbti.backEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "COMPANY")
public class Company extends NbtiEntity {

	private String companyName;

	private String address;

	private String city;

	private String region;

	private String contactPerson;

	private Integer telephoneNumber;

	private String email;

	@JsonManagedReference(value="studentCompany")
	@OneToMany(mappedBy = "currentCompany")
	private List<Student> studentsEmployed;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Integer getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Integer telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getStudentsEmployed() {
		return studentsEmployed;
	}

	public void setStudentsEmployed(List<Student> studentsEmployed) {
		this.studentsEmployed = studentsEmployed;
	}

	
}
