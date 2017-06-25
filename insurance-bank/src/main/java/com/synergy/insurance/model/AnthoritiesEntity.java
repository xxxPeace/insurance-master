package com.synergy.insurance.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="anthorities")
public class AnthoritiesEntity implements Serializable {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName="username")
	private LoginEntity user;
	
	private String anthority;

	public LoginEntity getUser() {
		return user;
	}

	public void setUser(LoginEntity user) {
		this.user = user;
	}

	public String getAnthority() {
		return anthority;
	}

	public void setAnthority(String anthority) {
		this.anthority = anthority;
	}
	
	
}
