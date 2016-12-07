package com.revature.wrappers;

import java.util.List;

public class WrapperClasses {
	// char, int, short, byte, long, double, float, boolean
	
	private int[] array;
	// generics cannot use primitive types!
	//private List<int> shorts;
	private List<Integer> shorts;
	
	public static void main(String[] args) {
		// wrapper classes: Decorator design pattern
		int value = 100;
		
		// Pre-Java 5
		Integer wrapper = new Integer(value); // boxing
		int backOut = wrapper.intValue(); // unboxing
		
		// Autoboxing
		int variable =100;
		Integer wrapped = variable; //autoboxing
		variable = wrapped;
		
		// more autoboxing
		value = wrapped + wrapper;
		
		String input = "9001";
		int parsedValue = Integer.parseInt(input);
		System.out.println(parsedValue);
	}
}






