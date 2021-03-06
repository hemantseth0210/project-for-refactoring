package com.sethjava.publisher;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sethjava.publisher.model.Book;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SpringCloudStreamPublisherApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
	}
	
	@PostMapping("/publish")
	public Book publishEvent(@RequestBody Book book) {
		return book;
	}
	
	@GetMapping("/message")
	public String message() {
		return "Hello";
	}

}
