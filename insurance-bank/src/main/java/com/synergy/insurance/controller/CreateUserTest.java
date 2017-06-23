package com.synergy.insurance.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.model.AnthoritiesEntity;
import com.synergy.insurance.model.LoginEntity;

@Controller
public class CreateUserTest {
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
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
		user1.setEmail("rockx@qq.com");
		user1.setPassword("123");
		user1.setEnabled(true);
		
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setAnthority("ROLE_USER");
		anth.setUser(user1);
		//hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.save(user1);
		hibernateTemplate.save(anth);
		return user1;
	}
}
