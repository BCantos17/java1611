package com.revature.collections;

import java.util.Comparator;

public class Trainee implements Comparable<Trainee>{

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" 
				+ name + ", major=" + major + "]";
	}
	// encapsulated, getter/setter naming, no-arg constructor
	private static int var;
	private int id;
	private String name;
	private String major;
	
	// static nested class
	static class TraineeNameComparator 
							implements Comparator<Trainee>{
		@Override
		public int compare(Trainee one, Trainee another) {
			var = 100; // accessing outer class static variables
			//major = "IT";   // will not compile
			return one.name.compareTo(another.name);
		}
		
	}
	
	// nested class
	class TraineeMajorComparator implements Comparator<Trainee>{
		// can access outer class's properties and methods
		public void example(){
			id = 100; var=100;
		}
		@Override
		public int compare(Trainee one, Trainee another) {
			return one.major.compareTo(another.major);
		}
		
	}
	
	
	@Override
	public int compareTo(Trainee other) {
		// natural ordering is ID least to greatest
		return this.id - other.id;
	}
	
	
	public Trainee() {
		super();
	}
	public Trainee(int id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (id != other.id)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
	
	
}







