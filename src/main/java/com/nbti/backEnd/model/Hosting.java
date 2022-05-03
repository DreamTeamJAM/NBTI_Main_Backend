package com.nbti.backEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOSTING")
public class Hosting implements Payee{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String address;

	private String city;

	private Integer postalCode;

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

	private Boolean foodInclude;

	@OneToMany(mappedBy = "currentHosting")
	private List<Student> studentsHosted;
	
	@OneToMany(mappedBy = "payedHosting")
	private List<HostingPayment> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
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

	public Boolean getFoodInclude() {
		return foodInclude;
	}

	public void setFoodInclude(Boolean foodInclude) {
		this.foodInclude = foodInclude;
	}

	public List<Student> getStudentsHosted() {
		return studentsHosted;
	}

	public void setStudentsHosted(List<Student> studentsHosted) {
		this.studentsHosted = studentsHosted;
	}

}
