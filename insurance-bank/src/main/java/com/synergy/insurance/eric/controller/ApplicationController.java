package com.synergy.insurance.eric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.eric.dao.ApplicationDao;
import com.synergy.insurance.eric.model.Application;

@Controller
@RequestMapping(path="/application")
public class ApplicationController {
	@Autowired
	ApplicationDao applicationDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<Application> getAllApplications() {
		return applicationDao.getAllApplications();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void updateApplication(@RequestBody Application application) {
		//TODO
		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/status/{status}")
	public List<Application> getApplicationsByStatus(@PathVariable String status) {
		return applicationDao.getApplicationsByStatus(status);
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/status/{status}")
	public void updateApplicationStatus(@PathVariable String status) {
		//TODO
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/email/{email}")
	public List<Application> getApplicationsByEmail(@PathVariable String email) {
		return applicationDao.getApplicationsByEmail(email);
	}
}
