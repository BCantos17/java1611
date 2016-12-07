package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;

public class EmployeeController {

	// employees.do
	public void doAll(HttpServletRequest request,
			HttpServletResponse response) 
					throws IOException, ServletException{
		
		// call services to grab data. put it into some scope
		List<Employee> list = someMiddleTierCall(request);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp")
			.forward(request, response);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<Employee> someMiddleTierCall
			(HttpServletRequest request){
		return (List<Employee>) 
				request.getServletContext().getAttribute("list");
	}
	
	

}




