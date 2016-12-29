package com.revature.data;

public class Facade {

	private DAO dao; 

	/**
	 * SETTER-INJECTION
	 * 	Spring says: here's your bean
	 * @param dao
	 */
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public void deleteAll(){
		// open a session
		// start a tx
		dao.deleteAll();
		// commit
		// close session
	}
	
}
