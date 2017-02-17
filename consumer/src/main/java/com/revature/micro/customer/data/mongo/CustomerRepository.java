package com.revature.micro.customer.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data interface for interacting with MongoDB. 
 * Connects to local Mongo service 
 * using the default port @27017 
 * and without authentication configured.
 * 
 * @author Patrick Walsh
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	/**
	 * This method will be invoked by Spring Integration when a message
	 * is sent to the CREATE_CUSTOMER topic in the Kafka queue.
	 */
	@Override
	public <S extends Customer> S save(S customer);
	

}