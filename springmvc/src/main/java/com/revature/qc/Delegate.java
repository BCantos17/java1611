package com.revature.qc;

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

	public Trainee getDan(){
		return facade.getDan();
	}
	
}
