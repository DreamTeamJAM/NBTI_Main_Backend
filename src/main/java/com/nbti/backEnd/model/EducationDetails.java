package com.nbti.backEnd.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class EducationDetails extends ActivityDetails {
	
	@Field
	private String center;

	@Field
	private List<String> fieldsOfStudy;
	
	@Field
	private String city;
	
}
