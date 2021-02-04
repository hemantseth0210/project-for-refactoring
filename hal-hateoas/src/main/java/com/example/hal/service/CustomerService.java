package com.example.hal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hal.model.Customer;

@Service
public class CustomerService {

	private HashMap<String, Customer> customerMap;
	
	public CustomerService() {
		customerMap = new HashMap<>();

        final Customer customerOne = new Customer("10A", "Jane", "ABC Company");
        final Customer customerTwo = new Customer("20B", "Bob", "XYZ Company");
        final Customer customerThree = new Customer("30C", "Tim", "CKV Company");

        customerMap.put("10A", customerOne);
        customerMap.put("20B", customerTwo);
        customerMap.put("30C", customerThree);
	}



	public Customer getCustomerDetail(String customerId) {
		return customerMap.get(customerId);
	}

	public List<Customer> allCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
