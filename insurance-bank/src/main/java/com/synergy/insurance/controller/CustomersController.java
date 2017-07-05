package com.synergy.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.CustomerDao;
import com.synergy.insurance.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomersController {
	@Autowired
	private CustomerDao customerDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/{email:.+}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		System.out.println(email);
		Customer customer = customerDao.getCustomerByEmail(email);
		System.out.println(customer);
		return customer;
//		return customerDao.getCustomerByEmail(email);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerDao.addCustomer(customer);
	}
}
