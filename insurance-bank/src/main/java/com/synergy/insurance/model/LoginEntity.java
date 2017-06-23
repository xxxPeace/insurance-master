package com.synergy.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class LoginEntity {
	@Id
	@Column(name="username", unique=true,nullable=false)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
