package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EDUCATION_DETAILS")
public class EducationDetails extends ActivityDetails {
	
	
	private String center;

	
	private String fieldsOfStudy;
	
	
	private String city;


	public String getCenter() {
		return center;
	}


	public void setCenter(String center) {
		this.center = center;
	}


	public String getFieldsOfStudy() {
		return fieldsOfStudy;
	}


	public void setFieldsOfStudy(String fieldsOfStudy) {
		this.fieldsOfStudy = fieldsOfStudy;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
