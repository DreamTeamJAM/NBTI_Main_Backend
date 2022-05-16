package com.nbti.backEnd.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class NbtiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime created;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime lastUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
