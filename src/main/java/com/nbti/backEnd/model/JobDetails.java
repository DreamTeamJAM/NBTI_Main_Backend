package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_DETAILS")
public class JobDetails extends ActivityDetails {

	private String company;

	private String city;

	private String tasks;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

}
