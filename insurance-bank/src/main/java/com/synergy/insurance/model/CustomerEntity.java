package com.synergy.insurance.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity implements Serializable{
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName="username")
	private LoginEntity user;
	
	private int age;
	private Date dob;
	private double salary;
	private String address;
	private String Occqupation;
	public LoginEntity getUser() {
		return user;
	}
	public void setUser(LoginEntity user) {
		this.user = user;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOccqupation() {
		return Occqupation;
	}
	public void setOccqupation(String occqupation) {
		Occqupation = occqupation;
	}
	
	
	
	
	
	
}
