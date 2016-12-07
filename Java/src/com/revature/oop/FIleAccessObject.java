package com.revature.oop;
								// IS-A  DAO
public class FIleAccessObject implements DataAccessObject{

	@Override
	public String readData() {
		System.out.println("reading from file");
		return "data";
	}

	@Override
	public void writeData(String data) {
		System.out.println("writing to file");
	}

	
	
}
