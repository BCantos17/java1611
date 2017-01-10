package com.revature.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Trainee;

public class TraineeDAO {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Inserts into database and returns generated ID
	 * @param trainee
	 * @return
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public Serializable insert(Trainee trainee){
		return sessionFactory.getCurrentSession().save(trainee);
	}
	
	/**
	 * Returns a trainee by its given identifier
	 * @param id
	 * @return
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public Trainee get(int id){
		return (Trainee) sessionFactory.getCurrentSession().get(Trainee.class, id);
	}
	
	/**
	 * Returns all trainees in the database
	 * @return
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<Trainee> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Trainee.class).list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void update(Trainee trainee){
		sessionFactory.getCurrentSession().saveOrUpdate(trainee);
	}
}
