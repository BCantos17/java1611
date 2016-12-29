package com.revature.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.Facade;

public class SpringTest {

	@Test
	public void hello(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		
		Facade facade = (Facade) context.getBean("facade");
		facade.deleteAll();
	}
	
}






