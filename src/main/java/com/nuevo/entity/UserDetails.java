package com.nuevo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class UserDetails {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	private String message;
	
	public UserDetails() { 

	}

	public UserDetails(String username, String message) {
		this.username = username;
		this.message = message;
	} 	
}

