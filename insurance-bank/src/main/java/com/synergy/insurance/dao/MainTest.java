package com.synergy.insurance.dao;

import com.synergy.insurance.model.Application;
import com.synergy.insurance.model.Users;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ApplicationDao appDao = new ApplicationDao();
		
		appDao.assignApplicationToEmployee(3, "rockx@qq.com");*/
		/*UsersDao ud = new UsersDao();
		Users user =ud.getUsersByEmail("rockx@qq.com");
		System.out.println(user);*/
		ApplicationDao appDao = new ApplicationDao();
		Application application = appDao.getApplicationByID(3);
		System.out.println(application);
		
	}

}
