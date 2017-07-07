package com.synergy.insurance.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.model.Application;
import com.synergy.insurance.model.Users;

@Service("applicationDao")
public class ApplicationDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Qualifier("usersDao")
	private UsersDao usersDao;
	
	
	public void createApplication(Application app){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		app.setDateApplied(ts);
		hibernateTemplate.save(app);
	}
	
	public void updateApplication(Application app){

	}
	public List<Application> getApplications(){
		List<Application> listApplications= (List<Application>) hibernateTemplate.find("from Application");		
		return listApplications;
		
	}
	public Application getApplicationByID(int id){
		List<Application> list = (List<Application>) hibernateTemplate.find("from Application where applicationId = ?",id);
		 if (list.size() != 0) {
		    return list.get(0);
		 } else {
		    return new Application();
		 }
	}
	
	public List<Application> getApplicationByStatus(String status){
		List<Application> listApplications = (List<Application>) hibernateTemplate.find("from Application where status = ?",status);
		return listApplications;
	}
	
	public List<Application> getApplicationByEmail(String email){
		List<Application> listApplications = (List<Application>) hibernateTemplate.find("from Application where email = ?",email);
		return listApplications;
	}
	
	public void updateApplicationStatus(int id, String status){
		System.out.println("updating application");
		Application application = getApplicationByID(id);
		application.setStatus(status);
		hibernateTemplate.saveOrUpdate(application);
		
	}
	
	public void assignApplicationToEmployee(int id, String email){
		System.out.println("assigning application");
		Users employee  = usersDao.getUsersByEmail(email);
		Application application = getApplicationByID(id);
		application.setAssignedEmployee(employee);
		hibernateTemplate.saveOrUpdate(application);
	}
	
	public List<Application> getApplicationByEmployee(String email){
		Users employee  = usersDao.getUsersByEmail(email);
		List<Application> listApplications = (List<Application>) hibernateTemplate.find("from Application where assignedEmployee = ?",employee);
		return listApplications;
	}
}
