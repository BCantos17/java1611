package com.revature.java;

public class Hello {

	// variables (state)
	int i;
	boolean b; 
	double d;
	float f;
	char c;
	long l;
	short s;
	byte by;
	String ref; 
	static final int num =100; // class variable
	final static Hello obj = new Hello();
	
	// methods (behavior)
	
	// entry point for your application
	public static void main(String[] args) {
		go();
	}
	
	static void go(){
		Student obj = new Student();
		obj.myLaptop = new Laptop();
		//obj.powerOff();
		int returned = obj.myLaptop.getMaxMemory();
		//System.out.println("Max memory is " + returned);
		
						//         argument
		obj.myLaptop.printUserName("dan");
	}
	
	/*
	 *  private - accessed within class
	 *   default - class, package
	 *    protected -  class, package, subclass
	 *     public - everyone 
	 */
	
	

}