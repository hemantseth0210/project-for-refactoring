package com.example.hal.model;

import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

public class Customer extends ResourceSupport {

	private String customerId;
    private String customerName;
    private String companyName;
    
    private Map<String, Order> orders;
    
    public Customer(String customerId, String customerName, String companyName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Map<String, Order> getOrders() {
		return orders;
	}
	public void setOrders(Map<String, Order> orders) {
		this.orders = orders;
	}
    
	
    
}
