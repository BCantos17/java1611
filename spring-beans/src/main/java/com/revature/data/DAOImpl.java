package com.revature.data;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DAOImpl implements DAO,
								InitializingBean,
								DisposableBean,
								BeanNameAware,
								ApplicationContextAware
{

	private String beanName;
	private ApplicationContext contxt;
	private String message; 			// Inject a value here

	/**
	 * Setter Injection
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void deleteAll() {
		System.out.println(message);
	}

	public DAOImpl() {
		System.out.println("DAOImpl() Constructor");
	}

	/**
	 * Init-Method
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("DAO Init-method");
	}

	public void destroy() throws Exception {
		System.out.println("DAO Destroy-method");
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("DAO Bean's name is" + beanName);
	}

	public void setApplicationContext(ApplicationContext contxt) throws BeansException {
		this.contxt = contxt;
		System.out.println("DAO bean lives in " + contxt);
	}
}






