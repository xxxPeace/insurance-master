package com.synergy.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.model.Application;
import com.synergy.insurance.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public void sendEmail(@RequestBody Application application) {
		emailService.sendEmail(application.getApplicationId(),application.getEmail());
	}
}
