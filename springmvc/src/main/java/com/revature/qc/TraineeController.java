package com.revature.qc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.qc.beans.Trainee;

@Controller
public class TraineeController {

	@ResponseBody
	@RequestMapping(value="/trainee/dan",
					method=RequestMethod.GET,
					produces="application/json"
					)
	public Trainee getDan(){
		return new Trainee(1, "Dan Pickles", "IT");
	}
	
}









