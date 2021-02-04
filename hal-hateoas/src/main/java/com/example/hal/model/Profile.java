package com.example.hal.model;

import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Profile {

	private String firstName;
    private String lastName;
    @JsonUnwrapped
    private Resources<EmbeddedWrapper> embeddeds;
   
    public Profile(String firstName, String lastName, Resources<EmbeddedWrapper> embeddeds) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.embeddeds = embeddeds;
	}
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Resources<EmbeddedWrapper> getEmbeddeds() {
		return embeddeds;
	}
	public void setEmbeddeds(Resources<EmbeddedWrapper> embeddeds) {
		this.embeddeds = embeddeds;
	}
    
    
}
