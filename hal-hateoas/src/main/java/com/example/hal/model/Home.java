package com.example.hal.model;

import org.springframework.hateoas.core.Relation;

@Relation(value = "home")
public class Home {

	private String streetName;
	private String zipCode;
	
	public Home(String streetName, String zipCode) {
		super();
		this.streetName = streetName;
		this.zipCode = zipCode;
	}
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
