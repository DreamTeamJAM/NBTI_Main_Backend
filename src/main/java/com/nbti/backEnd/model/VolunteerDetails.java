package com.nbti.backEnd.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class VolunteerDetails extends ActivityDetails{

	@Field
	private String Description;
}
