package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LANGUAGE_DETAILS")
public class LanguageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	public enum level {
		A1, A2, B1, B2, C1, C2
	}

	private level listening;

	private level reading;

	private level writing;

	private level spokenProduction;

	private level spokenInteraction;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public level getListening() {
		return listening;
	}

	public void setListening(level listening) {
		this.listening = listening;
	}

	public level getReading() {
		return reading;
	}

	public void setReading(level reading) {
		this.reading = reading;
	}

	public level getWriting() {
		return writing;
	}

	public void setWriting(level writing) {
		this.writing = writing;
	}

	public level getSpokenProduction() {
		return spokenProduction;
	}

	public void setSpokenProduction(level spokenProduction) {
		this.spokenProduction = spokenProduction;
	}

	public level getSpokenInteraction() {
		return spokenInteraction;
	}

	public void setSpokenInteraction(level spokenInteraction) {
		this.spokenInteraction = spokenInteraction;
	}
	
	

}
