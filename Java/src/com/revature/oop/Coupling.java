package com.revature.oop;

public class Coupling {

	public static void main(String[] args) {
		// FIleAccessObject obj = new new FIleAccessObject(); no thanks
		DataAccessObject obj = Factory.newInstance();
	}
	
}

class Factory{
	public static DataAccessObject newInstance(){
		return new DatabaseAccess();
	}
}






