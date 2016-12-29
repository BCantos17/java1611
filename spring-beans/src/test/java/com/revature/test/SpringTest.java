package com.revature.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.annotations.SpringAnnotationConfig;
import com.revature.data.DAO;
import com.revature.data.Facade;
import com.revature.web.BeanA;

public class SpringTest {
	
	@Test
	public void lifecycle(){
		/*AbstractApplicationContext ctxt = 
				new ClassPathXmlApplicationContext("beans.xml");*/
		AbstractApplicationContext ctxt = 
				new AnnotationConfigApplicationContext
					(SpringAnnotationConfig.class);
		
		ctxt.getBean("facade", Facade.class).deleteAll(); // bean in use

		System.err.println(ctxt.getBean("beanA", BeanA.class)
				== ctxt.getBean("beanA", BeanA.class));
		
		ctxt.registerShutdownHook(); // clean up all beans 
		// shutdown Spring container
	}

	@Ignore
	@Test 
	public void lazyInit(){
		ApplicationContext ctxt = 
				new ClassPathXmlApplicationContext("beans.xml");
		System.err.println("All eager beans instantiated!");
		ctxt.getBean("daoBean");
	}
	
	@Ignore
	@Test
	public void scope(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		
		Facade facade1 = (Facade) context.getBean("facade");
		Facade facade2 = (Facade) context.getBean("facade");
		System.out.println(facade1 == facade2);
	}
	
	@Ignore
	@Test
	public void hello(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		
		Facade facade = (Facade) context.getBean("facade");
		facade.deleteAll();
	}
	
}






