/**
 * 
 */
package com.sethjava.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.sethjava.consumer.model.Book;

/**
 * @author heseth
 *
 */
@Service
public class Consumer {
	
	private Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@StreamListener("input")
	public void consumeMessage(Book book) {
		logger.info("Consumer Payload : {}", book);
	}
}
