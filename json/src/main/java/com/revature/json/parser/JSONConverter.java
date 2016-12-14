package com.revature.json.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Car;
import com.revature.beans.Passenger;

public class JSONConverter {

	public Passenger getPassenger(String json) throws Exception{
		return new ObjectMapper().readValue(json, Passenger.class);
	}
	
	public Car getCar(String json) throws Exception{
		return new ObjectMapper().readValue(json, Car.class);
	}
	
	public String getJSON(Car car) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(car);
	}
	
	
}
