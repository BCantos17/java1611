package com.revature.micro.customer.data.mongo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerMessageReceiver {

	private CustomerRepository repository;

	@Autowired
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	private Log logger = LogFactory.getLog(CustomerMessageReceiver.class);
	
	/**
	 * This method will be invoked by Spring Integration when a message
	 * is sent to the CREATE_CUSTOMER topic in the Kafka queue.
	 * 
	 * @param customer
	 * @return
	 */
	// TODO create listener to handle incoming messages for a topic
	@KafkaListener(topics="CREATE_CUSTOMER")
	public <S extends Customer> S save(S customer) {
		logger.info("Kafka Consumer received message. Saving customer: " + customer);
		return repository.save(customer);
	}

}
