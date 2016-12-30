package com.revature.qc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.qc.beans.Trainee;

@Controller
public class TraineeController {

	@Autowired
	private Delegate businessDelegate;
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	@RequestMapping(value={"/home"}, method=RequestMethod.GET)
	// no response body.. returned value goes to IRVR
	public String homePage(){
		// InternalResourceViewResolver will prepend the prefix
				// /WEB-INF/pages/index.html
		// requestDispatcher.forward(req,resp)
		return "home"; 
	}
	
	// localhost:9001/springmvc/trainee/18
	@ResponseBody
	@RequestMapping(value="/trainee/{param}", 		// PathParam
					method=RequestMethod.GET,
					produces="application/json"
					)
	public Trainee getDan(@PathVariable(value="param") int id){
		return businessDelegate.getDan(id);
	}
	
	// localhost:9001/springmvc/trainee?q=__
	@ResponseBody
	@RequestMapping(value="/trainee", 		
					method=RequestMethod.GET,
					produces="application/json"
					)
	public Trainee getTrainee(@RequestParam(value="q") int id){
		return businessDelegate.getDan(id);
	}
	
	@ResponseBody
	@RequestMapping(value="trainees", method=RequestMethod.GET, 
					produces="application/json")
	public List<Trainee> getAll(){
		return businessDelegate.getAll();
	}
	
	@RequestMapping(value="/trainee/insert", method=RequestMethod.POST, 
					consumes="application/json")
	public ResponseEntity insert(@RequestBody @Valid Trainee obj, 
			BindingResult result){ // BResult holds errors
		if(result.hasErrors()){
			return new ResponseEntity("Failed",
					HttpStatus.BAD_REQUEST);
		}
		
		businessDelegate.insert(obj);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}









