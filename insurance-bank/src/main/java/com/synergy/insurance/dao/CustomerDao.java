package com.synergy.insurance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.insurance.model.Customer;

@Service
public class CustomerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Customer getCustomerByEmail(String email) {
		return hibernateTemplate.get(Customer.class,email);
	}
	
	@Transactional
	public void addCustomer(Customer customer) {
		hibernateTemplate.save(customer);
	}
}
