package com.revature.qc.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.revature.qc.beans.Trainee;

@Repository(value="dao")
@Scope(value="prototype")	// PROTOTYPE == stateful beans
public class DAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public Trainee getDanRecord(int id){
		return (Trainee) session.get(Trainee.class, id);
	}
	
	public List<Trainee> getAll(){
		return session.createCriteria(Trainee.class).list();
	}

	public void insert(Trainee obj) {
		session.saveOrUpdate(obj);
	}
}





