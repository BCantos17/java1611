package com.revature.lang;

public class StringStuff {

	public static void main(String[] args) {
		// mutable.. it changes the value instead of making 
		// new Strings each time
		char[] chars = {'a', 'b', 'c', 'd'};
		String result = ""; // immutable
		
		for(char temp: chars){
			result = result + temp;
		}// 4 Strings made
		System.out.println(result); 
		
		/////////////////////// mutable
		StringBuilder builder = new StringBuilder();
		for(char temp: chars){
			builder.append(temp);
		} 
		System.out.println( builder );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void equalExample(){
		
		String a = "Dan";
		String b = new String("Dan");
		
		System.out.println( a == b );
		System.out.println( a.equals(b) );
	}
}
