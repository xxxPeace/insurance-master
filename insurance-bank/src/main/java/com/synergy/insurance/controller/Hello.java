package com.synergy.insurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class Hello {
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello() {
		System.out.println("first commit");
		return "hellolala";
	}
}
