package com.revature.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

	@JsonProperty
	private String vin;
	@JsonProperty
	private int year;
	@JsonProperty
	private String make;
	@JsonProperty
	private String model;
	@JsonProperty
	private Passenger driver;
	
	@JsonProperty
	private List<Passenger> passengers;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Passenger getDriver() {
		return driver;
	}

	public void setDriver(Passenger driver) {
		this.driver = driver;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Car(String vin, int year, String make, String model, Passenger driver, List<Passenger> passengers) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.driver = driver;
		this.passengers = passengers;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", driver=" + driver
				+ ", passengers=" + passengers + "]";
	}
	
	
	
}
