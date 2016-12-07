package com.revature.beans;

public class Employee {

	private String firstName;
	private String lastName;
	private Department department;
	private Employee manager;
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Employee(String firstName, String lastName, Department department, Employee manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.manager = manager;
	}
	public Employee() {
		super();
	}

}
