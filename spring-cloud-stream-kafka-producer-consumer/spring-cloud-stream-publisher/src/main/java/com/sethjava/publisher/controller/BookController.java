/**
 * 
 */
package com.sethjava.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sethjava.publisher.model.Book;

/**
 * @author heseth
 *
 */
@RestController
public class BookController {

	/*
	 * @Autowired private MessageChannel output;
	 * 
	 * @PostMapping("/publish") public Book publishEvent(@RequestBody Book book) {
	 * output.send(MessageBuilder.withPayload(book).build()); return book; }
	 */
}