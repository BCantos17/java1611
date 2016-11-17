package com.revature.trash;

public class GCExample {

	public static void main(String[] args) {
		House house = new House();
		house = null; 
		System.gc(); // request 
		for(; ;){}
	}
	
}
class House{
	boolean lightsOn;
	
	@Override
	protected void finalize() throws Throwable {
		// last chance for cleanup
		for(; ;) System.out.println("Trash");
		
		/*if(lightsOn)
			lightsOn = false; // turn off
*/		/*
		 * if(database.isConnected()) database.close();
		 */
	}
}
