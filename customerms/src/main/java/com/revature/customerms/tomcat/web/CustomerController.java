package com.revature.customerms.tomcat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.customerms.tomcat.data.Customer;
import com.revature.customerms.tomcat.service.CustomerMongoService;

@RestController
public class CustomerController {

	private CustomerMongoService service;
	@Autowired
	public void setService(CustomerMongoService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer save(@RequestBody Customer customer){
		return service.save(customer);
	}
	@RequestMapping(value="/customer", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAll(){
		return service.findAll();
	}
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findOne(@PathVariable Integer id){
		return service.findOne(id);
	}
	@RequestMapping(value="/customer/age/{age}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByAge(@PathVariable int age){
		return service.findByAge(age);
	}
	@RequestMapping(value="/customer/last/{lastName}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName){
		return service.findByLastName(lastName);
	}
}
