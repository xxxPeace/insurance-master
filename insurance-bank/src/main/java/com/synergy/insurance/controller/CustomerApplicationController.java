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
import com.synergy.insurance.dao.LoginDao;
import com.synergy.insurance.dao.PasswordBuilder;
import com.synergy.insurance.model.Application;
import com.synergy.insurance.model.CustomerApplicationEntity;
import com.synergy.insurance.model.CustomerApplicationJson;
import com.synergy.insurance.model.LoginEntity;

@Controller
public class CustomerApplicationController {
	@Autowired
	@Qualifier("loginDao")
	LoginDao loginDao;
	
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
	@RequestMapping(value = "application",method=RequestMethod.POST)
	@ResponseBody public List<Application> updateApplications(@RequestBody Application app) {
		System.out.println("application");
		Application application = applicationDao.getApplicationByID(app.getApplicationId());
		application.setApplicationId(1);
		System.out.println(application);
		//applicationDao.createApplication(application);	
		return applicationDao.getApplications();	
	}
	
	//uri :http://localhost:8081/insurance-bank/webapi/application/status?status=pending
	@RequestMapping(value = "application/status",method=RequestMethod.POST)
	@ResponseBody public List<Application> getApplicationByStatus(@RequestParam("status") String status) {
		System.out.println("getApplicationByStatus");	
		return applicationDao.getApplicationByStatus(status);
	}
	
	//localhost:8081/insurance-bank/webapi/application/status?id=4&status=pending
	@Transactional
	@RequestMapping(value = "application/status",method=RequestMethod.PUT)
	@ResponseBody public void updateApplicationStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
		System.out.println("updateApplicationStatus");	
		applicationDao.updateApplicationStatus(id, status);
	}
	
	@Transactional
	@RequestMapping(value = "createApplicationOld",method=RequestMethod.POST)
	@ResponseBody public LoginEntity createCustomer(@RequestBody CustomerApplicationJson cusApp) {
		System.out.println("createCustomer");
		String password = PasswordBuilder.passwordBuilder();
		System.out.println("Password :" + password);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassword =encoder.encode( password);
		LoginEntity user = new LoginEntity();
		user.setEmail(cusApp.getEmail());	
		user.setPassword(encoderPassword);
		user.setEnabled(true);
		
		/*CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(cusApp.getName());
		customerEntity.setMobile(cusApp.getMobile());
		customerEntity.setAddress(cusApp.getAddress());
		customerEntity.setSsn(cusApp.getSsn());
		customerEntity.setDob(cusApp.getDob());
		customerEntity.setOccupation(cusApp.getOccupation());
		customerEntity.setSalary(cusApp.getSalary());
		customerEntity.setEducation(cusApp.getEducation());*/
		
		CustomerApplicationEntity customerApplicationEntity = new CustomerApplicationEntity();
		customerApplicationEntity.setName(cusApp.getName());
		customerApplicationEntity.setMobile(cusApp.getMobile());
		customerApplicationEntity.setAddress(cusApp.getAddress());
		customerApplicationEntity.setSsn(cusApp.getSsn());
		customerApplicationEntity.setDob(cusApp.getDob());
		customerApplicationEntity.setOccupation(cusApp.getOccupation());
		customerApplicationEntity.setSalary(cusApp.getSalary());
		customerApplicationEntity.setEducation(cusApp.getEducation());
		
		//customer.setUser(user1);
		//loginDao.createManager(user1);
		loginDao.createCustomerAplication(user, customerApplicationEntity);
		//loginDao.createThirdPraty(user1);
		return user;
	}
	
	
}
