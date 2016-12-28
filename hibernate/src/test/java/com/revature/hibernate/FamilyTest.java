package com.revature.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import beans.Child;
import beans.Parent;
import beans.Phone;
import beans.Toy;

public class FamilyTest {

	private SessionFactory sf = new Configuration()
			.configure().buildSessionFactory();
	
	@Test
	public void testMappings(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Phone phone1 = new Phone("555-1234"); session.save(phone1);
		Phone phone2 = new Phone("555-5689"); session.save(phone2);
				
		// two people who meet
		Parent dad = new Parent("Dan Pickles", phone1); 
		Parent mom = new Parent("Donna Pickles", phone2); 
		Set<Parent> couple = new HashSet<Parent>();
		couple.add(dad); couple.add(mom);

		// have kids
		Child son = new Child("Howard Johnson");
		Child daughter = new Child("Randolph Scott");
		session.save(son); session.save(daughter);
		
		// add kids to Parent and save. 
		// Parent class is owner of relationship
		dad.getKids().add(son); dad.getKids().add(daughter);
		mom.getKids().add(son); mom.getKids().add(daughter);

		session.save(dad); session.save(mom);
		
		// buy kids toys 
		Toy woody = new Toy("Woody", true, son);
		Toy buzz = new Toy("Bud Lightbeer", false, daughter);
		
		// persist the toys
		session.save(woody); session.save(buzz);
		
		tx.commit();
		session.close();
	}
	
}








