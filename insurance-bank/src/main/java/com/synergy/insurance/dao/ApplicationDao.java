package com.synergy.insurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.model.Application;

@Service("applicationDao")
public class ApplicationDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void createApplication(Application app){
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
	
	public void updateApplicationStatus(int id, String status){
		Application application = getApplicationByID(id);
		application.setStatus(status);
		hibernateTemplate.saveOrUpdate(application);
		
	}
}
