package com.synergy.insurance.eric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.eric.dao.UsersDao;
import com.synergy.insurance.eric.model.Users;

@Controller
@RequestMapping(path="/login")
public class LoginController {
	@Autowired
	UsersDao usersDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Users login(@RequestBody Users users) {
		return usersDao.authenticateUsers(users);
	}
}
