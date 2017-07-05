package com.synergy.insurance.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.synergy.insurance.dao.CustomerDao;
import com.synergy.insurance.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomersController {
	@Autowired
	private CustomerDao customerDao;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/{email:.+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerByEmail(@PathVariable String email) {
		System.out.println(email);
		Customer customer = customerDao.getCustomerByEmail(email);
		System.out.println(customer);
		Gson gson = new Gson();
		JsonElement je = gson.toJsonTree(customer);
		JsonObject jo = new JsonObject();
		jo.add("customer", je);
		String jsonInString = jo.toString();
		return jsonInString;
//		return customerDao.getCustomerByEmail(email);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
}
