package com.revature.qc.data;

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

	public Trainee getDanRecord(){
		int rowNum = 17;
		return (Trainee) session.get(Trainee.class, rowNum);
	}
}
