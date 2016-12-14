package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Passenger {

	@JsonProperty
	private String name;
	@JsonProperty
	private int age;
	@JsonProperty
	private boolean licensed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isLicensed() {
		return licensed;
	}
	public void setlicensed(boolean licensed) {
		this.licensed = licensed;
	}
	public Passenger(String name, int age, boolean licensed) {
		super();
		this.name = name;
		this.age = age;
		this.licensed = licensed;
	}
	public Passenger() {
		super();
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", licensed=" + licensed + "]";
	}
	
	
}
