package com.revature.oop;

/**
 * 
 * @author Owner
 *
 */
public class Polymorphism {
	
	public static void makeFood(Creature toProcess){
		
	}

	public static void main(String[] args) {
		// Pig pig = new Creature(); // IS-A failed
		Creature one = new Pig(); // IS-A check
		Creature two = new Cow();
		
		Creature[] farm = {one, two};
		
		// virtual method invocation
		farm[0].sound();
		farm[1].sound();
		makeFood(one);
		
		if(one instanceof Pig) System.out.println("One is a Pig");
		if(two instanceof Pig) System.out.println("Two is a Pig");
	}
	
}
class Creature{
	public void sound(){
		System.out.println("Bmm");
	}
}


class Pig extends Creature{
	@Override
	// exact same signature as a method in the parent class
	public void sound() { 
		System.out.println("Oink");
	}
	
	// Overloading
	// same name as method in same class.. different params
	public void sound(String soundToMake){
		System.out.println(soundToMake);
	}
}

class Cow extends Creature{
	@Override
	public void sound() {
		System.out.println("Moo");
	}
}


