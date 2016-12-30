package com.revature.qc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// registers it as a Spring bean
public class HelloController {

	@RequestMapping(value="hello",    	// if requestURI is "hello"
			method=RequestMethod.GET)	// And Http method is GET
										// call this method
	@ResponseBody 	// value returned ->> resp.getWriter().println()
	public String helloHandler(){
		return "Hello World"; 
	}
	
}






