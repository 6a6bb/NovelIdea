package com.huang.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String phonenumber;
	private int right_id;
	public static int PAGE_SIZE=3;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setright_id(int right_id) {
		this.right_id = right_id;
	}
	
	public int getright_id() {
		return right_id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
}
