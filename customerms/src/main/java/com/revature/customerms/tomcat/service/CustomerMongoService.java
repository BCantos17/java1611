package com.revature.customerms.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.customerms.tomcat.data.Customer;
import com.revature.customerms.tomcat.data.CustomerRepository;

@Service
public class CustomerMongoService {

	private CustomerRepository repository;
	@Autowired
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}
	public <S extends Customer> S save(S customer){
		return repository.save(customer);
	}
	public List<Customer> findAll(){
		return repository.findAll();
	}
	public Customer findOne(Integer id){
		return repository.findOne(id);
	}
	public List<Customer> findByAge(int age){
		return repository.findByAge(age);
	}
	public List<Customer> findByLastName(String lastName){
		return repository.findByLastName(lastName);
	}
}


