package com.revature.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/*
 * DAO class
 * @Repository declares this as a Spring bean
 * 
 */
@Scope(value="prototype")
@Lazy(value=true)
@Repository(value="beanA")
public class BeanA implements InitializingBean{

	public BeanA(){
		System.out.println("Bean A!!!!!");
	}

	public void afterPropertiesSet() throws Exception {
		
	}
	
}







