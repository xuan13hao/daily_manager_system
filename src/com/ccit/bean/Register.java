package com.ccit.bean;

public class Register {
	private int id;
	private String username;
	private String coder;
	private int isRegister;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCoder() {
		return coder;
	}
	public void setCoder(String coder) {
		this.coder = coder;
	}
	public int getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(int isRegister) {
		this.isRegister = isRegister;
	}
	public Register(int id, String username, String coder, int isRegister) {
		super();
		this.id = id;
		this.username = username;
		this.coder = coder;
		this.isRegister = isRegister;
	}
	public Register(String username, String coder, int isRegister) {
		super();
		this.username = username;
		this.coder = coder;
		this.isRegister = isRegister;
	}
	public Register() {
		super();
	}

	
}
