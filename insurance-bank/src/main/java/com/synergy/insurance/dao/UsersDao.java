package com.synergy.insurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.insurance.model.Users;

@Service("usersDao")
public class UsersDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Users getUsersByEmail(String email) {
		return hibernateTemplate.get(Users.class,email);
	}
	
	public Users validateLogin(Users users) {
		Users row = getUsersByEmail(users.getEmail());
		
		if(row == null || !users.getPassword().equals(row.getPassword())) {
			return null;
		}
		
		return row;
	}
	
	public List<Users> getThirdPartyUsers() {
		String query = "from Users where role=?";
		return (List<Users>) hibernateTemplate.find(query,"AGENT");
	}
	
	@Transactional
	public void addUser(Users user) {
		hibernateTemplate.save(user);
	}
	
	public Users getUserByEmail(String email) {
		return hibernateTemplate.get(Users.class,email);
	}
}
