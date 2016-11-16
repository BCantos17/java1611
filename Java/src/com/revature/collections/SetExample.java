package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main(String[] args) {
		Set<Student> classroom = new SetExample().createStudents();
/*		for(Student person : classroom){
			System.out.println(person.name);
		}*/
		List<Student> list = new ArrayList<>( classroom );
		//Collections.sort(list);
		
		for(Student person : list){
			System.out.println(person.name);
		}
	}

	// populate students
	private Set<Student> createStudents() {
		// Student[] classroom = new Student[17];
		TreeSet<Student> list = new TreeSet<>();
		Student a = new Student("Andrew Williams");
		list.add(a);
		list.add(new Student("David"));
		list.add(new Student("Andrew Chen"));
		list.add(new Student("Banks"));
		list.add(new Student("Sam"));
		list.add(new Student("Osher"));
		list.add(new Student("Martino"));
		list.add(new Student("Travis"));
		list.add(new Student("Bryan"));
		list.add(new Student("Rikki"));
		list.add(new Student("Salim"));
		list.add(new Student("Yan"));
		list.add(new Student("Shehar"));
		list.add(new Student("Louis"));
		list.add(new Student("Ilya"));
		list.add(new Student("Karina"));
		list.add(new Student("Kyle"));
		return list;
	}

}
