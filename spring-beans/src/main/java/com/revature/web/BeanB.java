package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Middle-tier component
 * @Service declares this as a Spring bean
 */
@Service
public class BeanB {
	
	@Autowired
	private BeanA dao;

}







