package com.revature.lang;

public class JavaLang {

	public static void main(String[] args) {	
		// prints all the elements
		int[] array = {1,2,3,4,5,6,7,8,9};
		for( int index=0; index < array.length; ++index ){
			//System.out.println( array[index] );
		}
		
		// for each temp in the array
					// iterable.. contains an iterator
		for(int temp : array){
			System.out.print(temp);
		}
		
	}
	
	
	
	
	
	/*		boolean isRunning = false;
	while( isRunning == true ){
		System.out.println("looping ");
		if( b() ){ // exit condition
			isRunning = false;
		}
	}
	
	do{
		System.out.println("looping break");
		if( b() ){ // exit condition
			break;
		}
	}while( true );
	
	// must execute at least once
	do{
		System.out.println("do-while");
	}while( true );*/
	public static boolean a(){
		System.out.println("a");
		return true;
	}
	public static boolean b(){
		return Math.random() > 0.8;
	}
}
