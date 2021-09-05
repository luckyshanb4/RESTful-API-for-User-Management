package com.Rest.RestAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="username",nullable = false)
	private String username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="email",nullable = true)
	private String email;

}
