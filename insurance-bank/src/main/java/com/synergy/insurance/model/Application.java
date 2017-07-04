package com.synergy.insurance.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class Application {
	@Id
	@GeneratedValue
	private int applicationId;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String ssn;
	private Timestamp dob;
	private String occupation;
	private double salary;
	private String education;
	@ManyToOne
	@JoinColumn
	private Users assignedEmployee;
	private Timestamp dateApplied;
	private Timestamp dateAssigned;
	private double fieldsFilledIn;
	private String status;
	private String policy;

	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Users getAssignedEmployee() {
		return assignedEmployee;
	}
	public void setAssignedEmployee(Users assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}
	public Timestamp getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(Timestamp dateApplied) {
		this.dateApplied = dateApplied;
	}
	public Timestamp getDateAssigned() {
		return dateAssigned;
	}
	public void setDateAssigned(Timestamp dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
	public double getFieldsFilledIn() {
		return fieldsFilledIn;
	}
	public void setFieldsFilledIn(double fieldsFilledIn) {
		this.fieldsFilledIn = fieldsFilledIn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", ssn=" + ssn + ", dob=" + dob + ", occupation=" + occupation
				+ ", salary=" + salary + ", education=" + education + ", assignedEmployee=" + assignedEmployee
				+ ", dateApplied=" + dateApplied + ", dateAssigned=" + dateAssigned + ", fieldsFilledIn="
				+ fieldsFilledIn + ", status=" + status + ", policy=" + policy + "]";
	}
	
	
	
}
