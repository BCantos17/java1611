package com.revature.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		// load students
		List<Student> list = new ListExample().createStudents();
		
		// print all students
/*		for(Student student : list){
			System.out.println(student.name);
		}*/
		
		// get by index
		System.out.println( list.get( 11 ).name );
		
		list.remove(11);
		
		System.out.println( list );
	}
	
	// populate students
	private List<Student> createStudents(){
		// Student[] classroom = new Student[17];
		ArrayList<Student> list = new ArrayList<>();
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
class Pickle{}
class Student{
	String name;
	public Student(String name) {
		super();
		this.name = name;
	}
}
