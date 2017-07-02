package com.synergy.insurance.eric.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.eric.model.Application;

@Service
public class ApplicationDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public List<Application> getAllApplications() {
		return (List<Application>) hibernateTemplate.find("from Application");
	}
	
	public List<Application> getApplicationsByStatus(String status) {
		String query = "from Application where status=?";
		return (List<Application>) hibernateTemplate.find(query);
	}
	
	public List<Application> getApplicationsByEmail(String email) {
		String query = "from Application where email=?";
		return (List<Application>) hibernateTemplate.find(query);
	}
}
