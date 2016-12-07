package com.revature.oop;

public class Example {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.name = "Dan Pickles"; // not encapsulated
		
		JavaBean bean = new JavaBean();
		bean.setColor("Brown"); // encapsulated
		
		Chevy c = new Chevy();
		c.turnOn();
	}
	
}
