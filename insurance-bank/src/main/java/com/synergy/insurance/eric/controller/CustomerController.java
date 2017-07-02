package com.synergy.insurance.eric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.eric.dao.CustomerDao;
import com.synergy.insurance.eric.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Customer getCustomer(@RequestBody Customer customer) {
		return customerDao.getCustomerByEmail(customer.getEmail());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerDao.addCustomer(customer);
	}
}
