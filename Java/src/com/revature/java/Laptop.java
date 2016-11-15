package com.revature.java;

public class Laptop {

	String brand;
	public void powerOff(){
		System.out.println("Shutting down..");
	}
	public int getMaxMemory(){
		return 10_000_000;
	}
	// 								pass in
	public void printUserName(String param){
		System.out.println(param);
	}
	//					varargs
	public void process(String batchName, 
			Student... students){
		
	}
	public void invoke(){
	
	}
	
}



