package com.revature.lang;

public class JavaLang {

	public static void main(String[] args) {	
		// works with byte, short, char, and int
		// also String and enum
		char a = 'a';
		
		switch(a){
			case 'a':{
				System.out.println("char is 'a'");
				break;
			}
			case 'b':{
				System.out.println("char is 'b'");
				break;
			}
			case 'A':{
				System.out.println("char is 'A'");
				break;
			}
			default: {
				System.out.println("char is something else");
				break;
			}
		}
	}
	
	
	
	
	
	/*		// prints all the elements
	int[] array = {1,2,3,4,5,6,7,8,9};
	for( int index=0; index < array.length; ++index ){
		//System.out.println( array[index] );
	}
	
	// for each temp in the array
				// iterable.. contains an iterator
	for(int temp : array){
		System.out.print(temp);
	}*/
	
	
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
