package com.demo.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.customer.model.Account;

@FeignClient(name = "account", url = "http://account:4080")
public interface AccountClient {

	@RequestMapping("/account/customer/{customerId}")
	List<Account> getAccounts(@PathVariable("customerId") Integer customerId,
			@RequestHeader(value="end-user", required=false) String user,
			@RequestHeader(value="x-request-id", required=false) String xreq,
			@RequestHeader(value="x-b3-traceid", required=false) String xtraceid,
			@RequestHeader(value="x-b3-spanid", required=false) String xspanid,
			@RequestHeader(value="x-b3-parentspanid", required=false) String xparentspanid,
			@RequestHeader(value="x-b3-sampled", required=false) String xsampled,
			@RequestHeader(value="x-b3-flags", required=false) String xflags,
			@RequestHeader(value="x-ot-span-context", required=false) String xotspan);
}
