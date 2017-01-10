package com.revature.api.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.beans.Trainee;
import com.revature.rest.client.TraineeApi;

public class ApiTest {

	@Test
	public void testUpdate(){
		Trainee t = new Trainee("Dan Pickles", "ITT Tech");
		t.setId(121);
		new TraineeApi().update(t);
	}
	
	@Test
	@Ignore
	public void testGetAll(){
		List<Trainee> trainees = new TraineeApi().getAll();
		for(Trainee t : trainees) System.out.println(t);
	}
	
	@Test
	@Ignore
	public void testGet(){
		Trainee trainee = new TraineeApi().find(130);
		System.out.println(trainee);
	}
	
	@Test
	@Ignore
	public void testInsert(){
		TraineeApi api = new TraineeApi();
		api.insert(new Trainee("Dan Pickles", "IT"));
	}
	
}
