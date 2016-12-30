package com.revature.qc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.qc.beans.Trainee;
import com.revature.qc.data.DataFacade;

@Service(value="businessDelegate")
public class Delegate {

	@Autowired
	private DataFacade facade;
	public void setFacade(DataFacade facade) {
		this.facade = facade;
	}

	public Trainee getDan(int id){
		return facade.getDan(id);
	}
	
	public List<Trainee> getAll(){
		return facade.getAll();
	}

	public void insert(Trainee obj) {
		facade.insert(obj);
	}
}
