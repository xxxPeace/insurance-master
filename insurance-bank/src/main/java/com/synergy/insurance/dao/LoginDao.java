package com.synergy.insurance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.synergy.insurance.model.AnthoritiesEntity;
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
	public void createCustomer(LoginEntity longinEntity){
		hibernateTemplate.save(longinEntity);
		AnthoritiesEntity anth = new AnthoritiesEntity();
		anth.setUser(longinEntity);
		anth.setAnthority("ROLE_CUSTOMER");
		hibernateTemplate.save(anth);
		CustomerEntity customer = new CustomerEntity();
		customer.setAddress("2213 ndsada ojfdsa way");
		customer.setAge(21);
		customer.setOccqupation("occqupation");
		customer.setSalary(21.22);
		customer.setUser(longinEntity);
		hibernateTemplate.save(customer);
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
