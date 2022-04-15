package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VOLUNTEER_DETAILS")
public class VolunteerDetails extends ActivityDetails {

	private String Description;

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
