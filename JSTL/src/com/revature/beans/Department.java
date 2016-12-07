package com.revature.beans;

public class Department {

	private String name;
	private double budget;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Department(String name, double budget) {
		super();
		this.name = name;
		this.budget = budget;
	}
	public Department() {
		super();
	}
}
