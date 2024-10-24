package com.piggymetrics.auth.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String roles;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}