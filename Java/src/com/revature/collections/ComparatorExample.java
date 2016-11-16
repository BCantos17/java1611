package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {
		// nested class
		Trainee.TraineeMajorComparator majorComparator =
				new Trainee().new TraineeMajorComparator();
		
		// static nested class
		Trainee.TraineeNameComparator nameComparator = 
				new Trainee.TraineeNameComparator();
		
		List<Trainee> classroom = new ArrayList<>();
		classroom.add(new Trainee(3, "Dan Pickles", "IT"));
		classroom.add(new Trainee(1, "Randolph Scott", "CS"));
		classroom.add(new Trainee(2, "Howard Johnson", "Business"));
		Collections.sort(classroom, nameComparator);
			
		for(Trainee t : classroom){
			System.out.println( t );
		}
	}
	
}
