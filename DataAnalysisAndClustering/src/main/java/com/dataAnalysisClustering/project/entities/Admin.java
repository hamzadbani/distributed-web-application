package com.dataAnalysisClustering.project.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
	
	   @Id
	   private String id;
	   
	   private String email;
	   private String password;
	   
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", Email=" + email + ", password=" + password + "]";
	}
	
	   
}
