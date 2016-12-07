package com.revature.java;

/**
 * src/main/java
 * Actual implementation.. not the test
 * @author Owner
 *
 */
public class CodingBat {
	public String firstHalf(String str){
		// check if str is null or if it is not even
		if((str == null) || ((str.length()%2) !=0))
			throw new IllegalArgumentException("Invalid input");
		// return from char index 0 thru to half the str length
		return str.substring(0, str.length()/2);
	}
}
