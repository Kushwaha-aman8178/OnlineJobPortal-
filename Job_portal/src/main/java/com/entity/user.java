package com.entity;

public class user {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String qual;
	private String role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public user(String name, String email, String password, String qual, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.qual = qual;
		this.role = role;
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
