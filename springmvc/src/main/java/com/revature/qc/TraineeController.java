package com.revature.qc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.qc.beans.Trainee;

@Controller
public class TraineeController {

	@Autowired
	private Delegate businessDelegate;
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@ResponseBody
	@RequestMapping(value="/trainee/dan",
					method=RequestMethod.GET,
					produces="application/json"
					)
	public Trainee getDan(){
		return businessDelegate.getDan();
	}
	
}









