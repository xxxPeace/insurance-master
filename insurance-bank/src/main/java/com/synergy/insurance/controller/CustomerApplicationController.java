package com.synergy.insurance.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.ApplicationDao;

import com.synergy.insurance.dao.PasswordBuilder;
import com.synergy.insurance.model.Application;


@Controller
public class CustomerApplicationController {
	
	
	@Autowired
	@Qualifier("applicationDao")
	ApplicationDao applicationDao;
	
	/*@Autowired
	@Qualifier("passwordBuilder")
	PasswordBuilder passwordBuilder;*/
	
	
	@Transactional
	@RequestMapping(value = "createApplication",method=RequestMethod.POST)
	@ResponseBody public void createApplication(@RequestBody Application app) {
		System.out.println("createApplication");
		applicationDao.createApplication(app);	
	}
	@RequestMapping(value = "application",method=RequestMethod.GET)
	@ResponseBody public List<Application> getApplications() {
		System.out.println("application");
		return applicationDao.getApplications();	
	}
	@Transactional
	@RequestMapping(value = "application",method=RequestMethod.POST)
	@ResponseBody public void updateApplications(@RequestBody Application app) {
		System.out.println("updateApplications");
		//applicationDao.createApplication(application);	
		applicationDao.updateApplication(app);	
	}
	
	//uri :http://localhost:8080/insurance-bank/webapi/application/status?status=pending
	@RequestMapping(value = "application/status",method=RequestMethod.GET)
	@ResponseBody public List<Application> getApplicationByStatus(@RequestParam("status") String status) {
		System.out.println("getApplicationByStatus");	
		return applicationDao.getApplicationByStatus(status);
	}
	//uri :http://localhost:8080/insurance-bank/webapi/application/status?email=peace@gmail.com
	@RequestMapping(value = "application/email",method=RequestMethod.GET)
	@ResponseBody public List<Application> getApplicationByEmail(@RequestParam("email") String email) {
		System.out.println("getApplicationByStatus");	
		return applicationDao.getApplicationByEmail(email);
	}
	
	//localhost:8080/insurance-bank/webapi/application/status?id=4&status=pending
	@Transactional
	@RequestMapping(value = "application/status",method=RequestMethod.PUT)
	@ResponseBody public void updateApplicationStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
		System.out.println("updateApplicationStatus");	
		applicationDao.updateApplicationStatus(id, status);
	}
	
	//localhost:8080/insurance-bank/webapi/application/assignEmployee?id=4&email=rockx@qq.com
	@Transactional
	@RequestMapping(value = "application/assignEmployee",method=RequestMethod.PUT)
	@ResponseBody public void assignApplicationToEmployee(@RequestParam("id") int id,  @RequestParam("email") String email) {
		System.out.println("updateApplicationStatus");	
		applicationDao.assignApplicationToEmployee(id, email);
	}
	
	//localhost:8080/insurance-bank/webapi/application/getApplicationByEmployee?email=rockx@qq.com
	@RequestMapping(value = "application/getApplicationByEmployee",method=RequestMethod.GET)
	@ResponseBody public List<Application> getApplicationByEmployee(@RequestParam("email") String email) {
		System.out.println("getApplicationByEmployee");	
		return applicationDao.getApplicationByEmployee(email);
	}
	
	
	
}
