package com.example.hal.model;

import org.springframework.hateoas.core.Relation;

@Relation(value = "email", collectionRelation = "emails")
public class Email {
	
	private String email;
    private String type;
    
    public Email(String email, String type) {
		super();
		this.email = email;
		this.type = type;
	}
    
	public String getEmail() {
		return email;
	}
	public String getType() {
		return type;
	}
    
    
}
