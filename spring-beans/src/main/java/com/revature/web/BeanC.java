package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * Web-tier.. a controller class
 * declares this as a Spring bean
 */

@Controller
public class BeanC {

	@Autowired
	private BeanB service;
	
}










