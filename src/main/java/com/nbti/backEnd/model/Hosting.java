package com.nbti.backEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "HOSTING")
public class Hosting extends NbtiEntity implements Payee {

	private String address;

	private String city;

	private String postalCode;

	private String landlord;

	private String region;

	private Integer telephone;

	private Integer number;

	private String email;

	private Double rentPerMonth;

	private Double deposit;

	private String iban;

	private Boolean usedBefore;

	private Integer bed;

	private Boolean linenRequired;

	private Boolean foodIncluded;
	
	//list of pictures of the hosting
	@JsonManagedReference(value="studentHosting")
	@OneToMany(mappedBy = "currentHosting")
	private List<Student> studentsHosted;

	@OneToMany(mappedBy = "payedHosting")
	private List<HostingPayment> payments;

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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLandlord() {
		return landlord;
	}

	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRentPerMonth() {
		return rentPerMonth;
	}

	public void setRentPerMonth(Double rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Boolean getUsedBefore() {
		return usedBefore;
	}

	public void setUsedBefore(Boolean usedBefore) {
		this.usedBefore = usedBefore;
	}

	public Integer getBed() {
		return bed;
	}

	public void setBed(Integer bed) {
		this.bed = bed;
	}

	public Boolean getLinenRequired() {
		return linenRequired;
	}

	public void setLinenRequired(Boolean linenRequired) {
		this.linenRequired = linenRequired;
	}

	public Boolean getFoodIncluded() {
		return foodIncluded;
	}

	public void setFoodIncluded(Boolean foodInclude) {
		this.foodIncluded = foodInclude;
	}

	public List<Student> getStudentsHosted() {
		return studentsHosted;
	}

	public void setStudentsHosted(List<Student> studentsHosted) {
		this.studentsHosted = studentsHosted;
	}

}
