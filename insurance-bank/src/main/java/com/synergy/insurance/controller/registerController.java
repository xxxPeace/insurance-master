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
import com.synergy.insurance.model.CustomerEntity;
import com.synergy.insurance.model.CustomerApplicationJson;
import com.synergy.insurance.model.LoginEntity;

@Controller
public class registerController {
	@Autowired
	@Qualifier("loginDao")
	LoginDao loginDao;
	
	@Transactional
	@RequestMapping(value = "createCustomer",method=RequestMethod.POST)
	@ResponseBody public LoginEntity createCustomer(@RequestBody CustomerApplicationJson customer) {
		System.out.println("createCustomer");
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password =encoder.encode( customer.getPassword());
		LoginEntity user = new LoginEntity();
		user.setEmail(customer.getEmail());	
		user.setPassword(password);
		user.setEnabled(true);
		System.out.println("createCustomer =" + customer.getPassword());
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customer.getName());
		customerEntity.setMobile(customer.getMobile());
		customerEntity.setAddress(customer.getAddress());
		customerEntity.setSsn(customer.getSsn());
		customerEntity.setDob(customer.getDob());
		customerEntity.setOccupation(customer.getOccupation());
		customerEntity.setSalary(customer.getSalary());
		customerEntity.setEducation(customer.getEducation());
		
		//customer.setUser(user1);
		//loginDao.createManager(user1);
		loginDao.createCustomer(user, customerEntity);
		//loginDao.createThirdPraty(user1);
		return user;
	}
}
