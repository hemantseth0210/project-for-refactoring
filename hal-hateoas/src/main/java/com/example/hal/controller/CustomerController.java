package com.example.hal.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hal.model.Customer;
import com.example.hal.model.Order;
import com.example.hal.service.CustomerService;
import com.example.hal.service.OrderService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	
	@Autowired
    private OrderService orderService;
 
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
    public Customer getCustomerById(@PathVariable String customerId) {
    	Link link = new Link("http://localhost:8080/customers/10A");
    	Customer customer = customerService.getCustomerDetail(customerId);
    	customer.add(link);
        return customer;
    }
    
    @RequestMapping(value = "/{customerId}/{orderId}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable final String customerId, @PathVariable final String orderId) {
        return orderService.getOrderByIdForCustomer(customerId, orderId);
    }
    
    @RequestMapping(value = "/{customerId}/orders", method = RequestMethod.GET , 
    		  produces = {"application/hal+json"})
    public Resources<Order> getOrdersForCustomer(@PathVariable final String customerId) {
        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        for (final Order order : orders) {
            Link selfLink = linkTo(methodOn(CustomerController.class)
              .getOrderById(customerId, order.getOrderId())).withSelfRel();
            order.add(selfLink);
        }
      
        Link link = linkTo(methodOn(CustomerController.class)
          .getOrdersForCustomer(customerId)).withSelfRel();
        Resources<Order> result = new Resources<Order>(orders, link);
        return result;
    }
    
    
    @RequestMapping(method = RequestMethod.GET, produces = {"application/hal+json"})
    public Resources<Customer> getAllCustomers() {
        final List<Customer> allCustomers = customerService.allCustomers();
        
        for (final Customer customer : allCustomers) {
            String customerId = customer.getCustomerId();
            Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
            customer.add(selfLink);
            if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
                final Link ordersLink = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withRel("allOrders");
                customer.add(ordersLink);
            }
        }
        
        Link link =linkTo(CustomerController.class).withSelfRel();
        Resources<Customer> result = new Resources<>(allCustomers,link);
        return result;
    }

    
    
    
    
}
