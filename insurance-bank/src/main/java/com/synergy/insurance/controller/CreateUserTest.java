package com.synergy.insurance.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.LoginDao;
import com.synergy.insurance.model.AnthoritiesEntity;
import com.synergy.insurance.model.CustomerEntity;
import com.synergy.insurance.model.LoginEntity;

@Controller
public class CreateUserTest {

	@Autowired
	@Qualifier("loginDao")
	private LoginDao loginDao;
	
	//test will return object as Json format
	@RequestMapping(value = "usertest",method=RequestMethod.GET)
	@ResponseBody public LoginEntity userTest() {
		System.out.println("user test");
		LoginEntity user1 = new LoginEntity();
		user1.setEmail("rockx@qq.com");
		user1.setPassword("123");
		user1.setEnabled(true);
		
		return user1;
	}
	
	@Transactional
	@RequestMapping(value = "userSaveTest",method=RequestMethod.GET)
	@ResponseBody public LoginEntity userSaveTest() {
		System.out.println("user save test");
		LoginEntity user1 = new LoginEntity();
		user1.setEmail("rtandsadsa2@qq.com");
		user1.setPassword("123");
		user1.setEnabled(true);
		
		//loginDao.createManager(user1);
		loginDao.createCustomer(user1);
		//loginDao.createThirdPraty(user1);
		return user1;
	}
	
	@RequestMapping(value = "getUserByEmail",method=RequestMethod.GET)
	@ResponseBody public LoginEntity getUserByEmail() {
		System.out.println("getUserByEmail");
		LoginEntity user = loginDao.getUserByEmail("rtan11222@qq.com");
		return user;
	}
	
	@RequestMapping(value = "getCustomerByEmail",method=RequestMethod.GET)
	@ResponseBody public CustomerEntity getCustomerByEmail() {
		System.out.println("getCustomerByEmail");
		CustomerEntity customer = loginDao.getCustomerByEmail("rtandsadsa2@qq.com");
		return customer;
	}
	
	@Transactional
	@RequestMapping(value = "deleteCustomerByEmail",method=RequestMethod.GET)
	@ResponseBody public void deleteCustomerByEmail() {
		System.out.println("deleteCustomerByEmail");
		loginDao.deleteCustomerByEmail("rtandsadsa2@qq.com");
	}
}
