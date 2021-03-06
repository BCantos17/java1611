package com.revature.micro.product.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	
	/**
	 * For example purposes, this connects directly to MongoDB for some operations
	 */
	private CustomerRepository repository;
	/**
	 * For the "save" operation, this sends message to customer-microservice
	 */
	private CustomerMessageSender customerMessageSender;
	
	@Autowired
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setCustomerMessageSender(CustomerMessageSender customerMessageSender) {
		this.customerMessageSender = customerMessageSender;
	}

	/**
	 * Does not handle locally. Sends message to Kafka
	 * @param customer
	 * @return
	 */
	public void save(Customer customer){
		customerMessageSender.saveCustomer(customer);
	}
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
}
