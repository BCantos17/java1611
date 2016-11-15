package com.revature.oop;
/**
 * Inheritance
 * @author Owner
 *
 */
public class Animal {
	String name;
	public void eat(){}
}


class Feline extends Animal{ // IS-A
	public Feline(){
		System.out.println(name);
		eat();
	}
} 
