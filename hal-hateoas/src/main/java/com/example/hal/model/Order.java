package com.example.hal.model;

import org.springframework.hateoas.ResourceSupport;

public class Order extends ResourceSupport{

	private String orderId;
	private double price;
	private int quantity;
	 
	public Order(String orderId, double price, int quantity) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 
	 
}
