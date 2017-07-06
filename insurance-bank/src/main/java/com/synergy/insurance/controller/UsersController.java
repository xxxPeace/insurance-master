package com.synergy.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.UsersDao;
import com.synergy.insurance.model.Users;

@Controller
@RequestMapping("/login")
public class UsersController {
	@Autowired
	private UsersDao usersDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Users validateLogin(@RequestBody Users users) {
		return usersDao.validateLogin(users);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/thirdParty")
	public List<Users> getThirdPartyUsers() {
		return usersDao.getThirdPartyUsers();
	}
}
