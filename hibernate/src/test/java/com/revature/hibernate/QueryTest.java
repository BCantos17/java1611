package com.revature.hibernate;

import org.junit.Ignore;
import org.junit.Test;

public class QueryTest {
	
	static TraineeDAO dao = new TraineeDAO();
	
	@Test
	public void delete(){
		Trainee obj = dao.get(60);
		dao.delete(obj);
	}
	
	@Test
	@Ignore
	public void testUpdate(){
		Trainee obj = dao.get(60); // obj is now "persisted"
		obj.setMajor("Nanotechnology");
		dao.update(obj);
	}
	
	@Test
	@Ignore
	public void getAll(){
		for(Trainee t : dao.findBy("CS"))
			System.out.println(t);
	}
	
	@Test
	@Ignore
	public void get(){
		System.out.println("GET: " + dao.get(60));
		System.out.println("GET: " + dao.get(9000000));
	}
	
	@Test
	@Ignore
	public void load(){
		System.out.println("LOAD: " + dao.load(60));
		System.out.println("LOAD:" + dao.load(9000000));
	}

	@Test
	@Ignore
	public void test(){
		TraineeDAO dao = new TraineeDAO();
		System.out.println( dao.getById(60) );
	}
	
}
