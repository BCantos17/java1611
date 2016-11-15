package com.revature.java;

public class Human {
	
	private int age;
	private String name;
	public Human(int age, String name) {
		super(); // constructor chaining
		this.age = age;
		this.name = name;
	}
	public Human() {
		this(1, "Dan");
		System.out.println("Making a human");
	}
	public static void main(String[] args) {
		Human h = new Human();
		System.out.println(h);
	}
	
	@Override
	public String toString() {
		return name + " is " + age + " years old";
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		// validate age > 0
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
