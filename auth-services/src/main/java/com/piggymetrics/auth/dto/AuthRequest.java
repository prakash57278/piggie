package com.piggymetrics.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AuthRequest {

    private String name;
    private String password;
    
    
	public AuthRequest(String name, String password) {

		this.name = name;
		this.password = password;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}