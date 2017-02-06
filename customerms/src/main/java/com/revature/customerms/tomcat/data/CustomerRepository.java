package com.revature.customerms.tomcat.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.lang.String;
import com.revature.customerms.tomcat.data.Customer;

/**
 * Spring Data generates ALL the MongoDB JDBC code
 * Crazy black-box stuff going on here...
 */
public interface CustomerRepository 
	extends MongoRepository<Customer, Integer>{

	// Create	
	<S extends Customer> S save(S customer);
	// Retrieve all
	List<Customer> findAll();
	// Retrieve by Id
	Customer findOne(Integer id);
	// Retrieve by Age -- "query" by a property
	List<Customer> findByAge(int age);
	List<Customer> findByLastName(String lastname);
}








