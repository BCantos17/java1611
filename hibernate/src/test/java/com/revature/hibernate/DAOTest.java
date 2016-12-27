package com.revature.hibernate;

import org.junit.Test;

public class DAOTest {

	@Test
	public void testInsert(){
		TraineeDAO dao = new TraineeDAO();
		Trainee trainee = new Trainee(109, "Howard Johnson","IT");
		dao.insert(trainee);
	}
	
}
