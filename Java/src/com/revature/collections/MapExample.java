package com.revature.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	
	public static void main(String[] args) {
		new MapExample().populate();
	}

	private Map<String, Trainee> populate(){
		HashMap<String, Trainee> map = 
				new HashMap<String, Trainee>();
		map.put("pjw6193", new Trainee(1, "Patrick", "IT"));
		map.put("danp", new Trainee(2, "Dan Pickles", "CS"));
		
		// overwrites 'danp' entry
		map.put("danp", new Trainee(2, "Danny Pickle", "Business"));
		
		// one null key is allowed.. multiple null values are okay
		map.put(null, new Trainee(5, "Null guy", "No major"));
		
		// nothing happens. pjw6193 already exists
		map.putIfAbsent("pjw6193", new Trainee()); 
		
		// show all keys
		Set<String> keys = map.keySet();
		for(String key : keys) {
			//System.out.println(key);
		}
		
		// show all the values
		Collection<Trainee> values = map.values();
		for(Trainee value : values) {
			//System.out.println(value.getName());
		}

		// random access a value by using its key
		Trainee retrieved = map.get("danp");
		//System.out.println(retrieved.getName());
		
		// show everything in the map
		for(String key : map.keySet()){
			System.out.println("Key: " + key 
							+ " Value: " + map.get(key).getMajor());
		}
		
		return map;
	}
}




