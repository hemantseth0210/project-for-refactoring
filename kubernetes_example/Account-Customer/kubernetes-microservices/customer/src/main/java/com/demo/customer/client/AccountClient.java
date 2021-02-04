package com.demo.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account", url = "http://account-service:4080")
public interface AccountClient {

	@RequestMapping("/accounts")
	public String findAll();
}
