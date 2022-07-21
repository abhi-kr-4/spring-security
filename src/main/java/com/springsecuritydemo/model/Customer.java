package com.springsecuritydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity    // represents spring boot and jpa that we have a table in the database with the name 'customer'
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //tell JPA framework that it is auto incremented 
	private int id;
	private String email;// maps to the column name with same in the database
	private String pwd;  // to map to a particular column, use @Column
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
