package com.demo.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customer.client.AccountClient;
import com.demo.customer.model.Account;
import com.demo.customer.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private AccountClient accountClient;
	
	@RequestMapping("/customer/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id,
			@RequestHeader(value="end-user", required=false) String user,
			@RequestHeader(value="x-request-id", required=false) String xreq,
			@RequestHeader(value="x-b3-traceid", required=false) String xtraceid,
			@RequestHeader(value="x-b3-spanid", required=false) String xspanid,
			@RequestHeader(value="x-b3-parentspanid", required=false) String xparentspanid,
			@RequestHeader(value="x-b3-sampled", required=false) String xsampled,
			@RequestHeader(value="x-b3-flags", required=false) String xflags,
			@RequestHeader(value="x-ot-span-context", required=false) String xotspan) {
		
		Customer customer = new Customer(id, "Mary", "Sobers", "20-Oct-1986","Female","2015347623","5514454221");
		List<Account> accounts =  accountClient.getAccounts(id, user, xreq, xtraceid, xspanid, xparentspanid, xsampled, xflags, xotspan);
		customer.setAccounts(accounts);
		return ResponseEntity.ok(customer);
	}
	
}
