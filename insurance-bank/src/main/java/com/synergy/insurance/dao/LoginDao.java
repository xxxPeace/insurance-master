package com.synergy.insurance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.model.AnthoritiesEntity;
import com.synergy.insurance.model.CustomerApplicationEntity;
import com.synergy.insurance.model.CustomerEntity;
import com.synergy.insurance.model.LoginEntity;

@Service("loginDao")
public class LoginDao {
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void createManager(LoginEntity longinEntity){
		hibernateTemplate.save(longinEntity);
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setUser(longinEntity);
		anth.setAnthority("ROLE_MANAGER");
		hibernateTemplate.save(anth);
	}
	
	
	public void createThirdPraty(LoginEntity longinEntity){
		hibernateTemplate.save(longinEntity);
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setUser(longinEntity);
		anth.setAnthority("ROLE_THIRDPARTY");
		hibernateTemplate.save(anth);
	}
	
	public LoginEntity getUserByEmail(String email){
		LoginEntity user = hibernateTemplate.get(LoginEntity.class, email);
		return user;
	}
	
	public AnthoritiesEntity getAnthByEmail(String email){
		AnthoritiesEntity anth = hibernateTemplate.get(AnthoritiesEntity.class, email);
		return anth;
	}
	
	
	public void createCustomer(LoginEntity longinEntity, CustomerEntity customer){
		hibernateTemplate.save(longinEntity);
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setUser(longinEntity);
		anth.setAnthority("ROLE_CUSTOMER");
		customer.setUser(longinEntity);
		customer.setUser(longinEntity);
		hibernateTemplate.save(anth);
		hibernateTemplate.save(customer);
	}
	
	public void createCustomerAplication(LoginEntity longinEntity, CustomerApplicationEntity cusapp){
		hibernateTemplate.save(longinEntity);
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setUser(longinEntity);
		anth.setAnthority("ROLE_CUSTOMER");
		cusapp.setUser(longinEntity);
		cusapp.setUser(longinEntity);
		hibernateTemplate.save(anth);
		hibernateTemplate.save(cusapp);
	}
	public CustomerEntity getCustomerByEmail(String email){
		CustomerEntity customer = hibernateTemplate.get(CustomerEntity.class, email);
		return customer;
	}
	
	public void deleteCustomerByEmail(String email){
		LoginEntity user = this.getUserByEmail(email);
		AnthoritiesEntity anth = this.getAnthByEmail(email);
		CustomerEntity customer = this.getCustomerByEmail(email);
		hibernateTemplate.delete(customer);
		hibernateTemplate.delete(anth);
		hibernateTemplate.delete(user);
	}
}
