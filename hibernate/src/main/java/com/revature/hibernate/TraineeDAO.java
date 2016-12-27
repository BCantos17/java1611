package com.revature.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TraineeDAO {

	public void insert(Trainee trainee){
		// don't do this.. use Singleton SessionFactory
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();
		// open a session.. always use Session-per-HTTP-request
		Session session = sf.openSession();
		// begin a transaction
		Transaction tx = session.beginTransaction();
		// save the object
		session.save(trainee);
		// commit
		tx.commit();
		// always close sessions before we send HTTP response
		session.close();
	}
	
}






