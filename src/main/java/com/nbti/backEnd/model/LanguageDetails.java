package com.nbti.backEnd.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class LanguageDetails {

	@Field
	private String name;

	public enum level {
		A1, A2, B1, B2, C1, C2
	}

	@Field
	private level listening;
	
	@Field
	private level reading;
	
	@Field
	private level writing;
	
	@Field
	private level spokenProduction;
	
	@Field
	private level spokenInteraction;

}
