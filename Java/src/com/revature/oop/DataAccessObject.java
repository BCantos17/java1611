package com.revature.oop;

/**
 * Class will work with a single line of data
 * @author Owner
 *
 *	Rules for all the classes the implement it
 *	
 * 
 * */
public interface DataAccessObject {

	//public static final 
	int id =100;
	public String readData();
	public void writeData(String data);
	// Java 8
	public default void method(){
		System.out.println("default method");
	}
	
}





