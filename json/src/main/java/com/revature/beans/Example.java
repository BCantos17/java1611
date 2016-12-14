package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

public class Example {

	public static Car load(){
		Passenger driver = new Passenger("Dan Pickles", 21, true);
		Passenger shotgun = new Passenger("Randolph Scott", 25, true);
		Passenger backseatDriver = 
				new Passenger("Howard Johnson", 45, false);
		
		List<Passenger> riders = new ArrayList<Passenger>();
		riders.add(shotgun); riders.add(backseatDriver);
		
		return new Car("HGASDYT1871782HA",
				1995, "Honda", "Civic", 
				driver, riders);
	}
	
}
