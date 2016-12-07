package com.revature.exceptions;

public class RuntimeExamples {

	static Door door = new Door();
	
	public static void main(String[] args) {
		new House().close(door);
		
		int[] array = {1,2,3};
/*		for(int i=0; i<5; i++){
			System.out.println(array[i]);
		}*/
		String word = "Java";
		for(int i=0; i < word.length(); i++){
			System.out.println( word.charAt(i) );
		}
		
	}
	
}
class House{
	public void close(Door door){
		if(door != null)
			door.close();
		else
			System.out.println("Give me a door to close");
	}
}
class Door{
	public void close(){
		System.out.println("Closing door");
	}
}
