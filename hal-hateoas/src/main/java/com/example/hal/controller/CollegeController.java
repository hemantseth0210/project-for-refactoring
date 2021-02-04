package com.example.hal.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hal.model.College;
import com.example.hal.model.Program;
import com.example.hal.model.Student;

/*
 * https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support/25874652#25874652
 * 
 */

@RestController
@RequestMapping(value = "/colleges")
public class CollegeController {

	 @RequestMapping(value = "/college", method = RequestMethod.GET)
	    public ResponseEntity<College> getCustomerById() {
		    Student student = new Student("101", "John Doe");
		    Program program = new Program("1A", "Comp Sc");
	        
		    Resource<Student> r1 = new Resource<>(student, new Link("http://example.com/student/101"));
	        Resource<Program> r2 = new Resource<>(program, new Link("http://example.com/program/1A"));
	       // Link link = new Link("http://example.com/order/1/products/");
	        
	        College college = new College("Rienhart", "Solstice Loop");
	        Link link = new Link("http://localhost:8080/colleges/college");
	        college.add(link);
	        college.embed("student", r1);
	        college.embed("program", r2);
	        
	        return ResponseEntity.ok(college);
	    }
}
