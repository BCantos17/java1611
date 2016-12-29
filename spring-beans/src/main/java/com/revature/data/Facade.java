package com.revature.data;

import org.springframework.beans.factory.annotation.Autowired;

public class Facade {

	@Autowired
	private DAO dao; 
	
	/**
	 * CONSTRUCTOR-INJECTION
	 * @param dao
	 */
	public Facade(DAO dao){
		this.dao = dao;
		System.out.println("Facade(DAO dao) constructor");
	}

	/**
	 * SETTER-INJECTION
	 * 	Spring says: here's your bean
	 * @param dao
	 */
	public void setDao(DAO dao) {
		System.out.println("Facade: setting DAO");
		this.dao = dao;
	}

	public void deleteAll(){
		// open a session
		// start a tx
		dao.deleteAll();
		// commit
		// close session
	}

	/**
	 * Custom init-method. Spring will automagically invoke these
	 */
	public void initialize(){
		System.out.println("Initializing Facade...");
	}
	
	/**
	 * Custom destroy-method
	 */
	public void cleanup(){
		System.out.println("Cleanup Facade...");
	}
	
	public Facade() {
		System.out.println("Facade() constructor");
	}
}
