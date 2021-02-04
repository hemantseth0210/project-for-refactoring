package com.demo.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customer.client.AccountClient;

@RestController
public class CustomerController {

	@Autowired
	private AccountClient accountClient;
	
	@RequestMapping("/customer")
	public String findAll() {
		String customerAccountInfo = "User Name - Hemant Seth ";
		customerAccountInfo = customerAccountInfo.concat(accountClient.findAll());
		return customerAccountInfo;
	}
}
