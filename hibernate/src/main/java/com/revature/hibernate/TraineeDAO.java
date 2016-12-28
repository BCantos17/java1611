package com.revature.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TraineeDAO {
	
	private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();
	
	public void update(Trainee trainee){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		/* 
		 * Update specific fields only:
		 * HQL = update Trainee set major = :newMajor where id = :pk
		 * query.executeUpdate();
		 * 
		*/
		session.saveOrUpdate(trainee);
		tx.commit();
	}
	public void delete(Trainee trainee){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(trainee);
		tx.commit();
	}
	
	public List<Trainee> getAll(){
		Session session = sf.openSession();
		Query query = session
				.createQuery("from com.revature.hibernate.Trainee");
		return query.list();
	}
	
	public Set<Trainee> findBy(String major){
		Session session = sf.openSession();
		String HQL = "from Trainee where major = :q";
		Query query = session
				.createQuery(HQL);
		query.setString("q", major);
		return new HashSet<Trainee>(query.list());
	}
	
	public Trainee load(int id){
		return (Trainee) sf.openSession().load(Trainee.class, id);
	}
	public Trainee get(int id){
		return (Trainee) sf.openSession().get(Trainee.class, id);
	}
	
	public Trainee getById(int id){
		Session session = sf.openSession();
		// HQL -> Hibernate Query Language
		// 	object-oriented SQL
		// 	#1 benefit == decoupled DAO from DB. 
				// no reliance on SQL dialects
		// String SQL = "SELECT * FROM TRAINEE WHERE TRAINEE_ID = ?";
		String HQL = "FROM com.revature.hibernate.Trainee "
				+ "WHERE id = :pk";
		Query query = session.createQuery(HQL);
		query.setInteger("pk", id);
		Trainee trainee = (Trainee) query.uniqueResult();
		return trainee;
	}

	public void insert(Trainee trainee){
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






