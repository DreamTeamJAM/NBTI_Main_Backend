package com.nbti.backEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NBTI_USER")
public class Users extends NbtiEntity {

	@Column(unique = true)
	public String username;

	public String password;

	public String role;

	public Users() {
	}

	public Users(Long id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}