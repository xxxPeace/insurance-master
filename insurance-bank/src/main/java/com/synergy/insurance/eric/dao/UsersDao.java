package com.synergy.insurance.eric.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.eric.model.Users;

@Service
public class UsersDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Users getUsersByEmail(String email) {
		return hibernateTemplate.get(Users.class,email);
	}
	
	public Users authenticateUsers(Users users) {
		Users row = getUsersByEmail(users.getEmail());
		
		if(row == null || !row.getPassword().equals(users.getPassword()))
			return null;
		
		return row;
	}
}
