package com.demo.account.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.model.Account;

@RestController
public class AccountController {

	@RequestMapping("/account/customer/{customerId}")
	public ResponseEntity<?> findByCustomer(@PathVariable("customerId") Integer customerId,  
			@RequestHeader(value="end-user", required=false) String user,
			@RequestHeader(value="x-request-id", required=false) String xreq,
			@RequestHeader(value="x-b3-traceid", required=false) String xtraceid,
			@RequestHeader(value="x-b3-spanid", required=false) String xspanid,
			@RequestHeader(value="x-b3-parentspanid", required=false) String xparentspanid,
			@RequestHeader(value="x-b3-sampled", required=false) String xsampled,
			@RequestHeader(value="x-b3-flags", required=false) String xflags,
			@RequestHeader(value="x-ot-span-context", required=false) String xotspan) {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("101", customerId, "5631294243", "$25000", "JFK BLVD", "Bank Of America","Newyork","07110"));
		accounts.add(new Account("102", customerId, "8345992234", "$40000", "Rienhart Road", "JP Morgan","Sanford","32771"));
		return ResponseEntity.ok(accounts);
		//return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}
	
}
