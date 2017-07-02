package com.synergy.insurance.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.LoginDao;
import com.synergy.insurance.dao.PasswordBuilder;
import com.synergy.insurance.model.CustomerApplicationEntity;
import com.synergy.insurance.model.CustomerApplicationJson;
import com.synergy.insurance.model.LoginEntity;

@Controller
public class CustomerApplicationController {
	@Autowired
	@Qualifier("loginDao")
	LoginDao loginDao;
	
	/*@Autowired
	@Qualifier("passwordBuilder")
	PasswordBuilder passwordBuilder;*/
	
	@Transactional
	@RequestMapping(value = "createApplication",method=RequestMethod.POST)
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
