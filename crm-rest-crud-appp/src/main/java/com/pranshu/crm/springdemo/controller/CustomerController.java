package com.pranshu.crm.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public String landing()
	{
		return "index";
	}
}
