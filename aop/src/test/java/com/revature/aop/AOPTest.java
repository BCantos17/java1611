package com.revature.aop;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("aop.xml");
	}
	
	@Test
	public void aroundadvice(){
		int val = context.getBean(Module.class).moreFun();
		System.out.println("Test class received " + val);
	}
	
	@Ignore
	@Test
	public void returnThrow(){
		String value = context.getBean(Module.class).fun();
		System.out.println("Test class received " + value);
	}
	
	@Test
	@Ignore
	public void hello(){
		context.getBean("module", Module.class).doWork();
	}
	
}



