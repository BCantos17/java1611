package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
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
		if(Math.random() > 0.5){
			request.setAttribute("msg", "You have mail");
		}
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp")
			.forward(request, response);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<Employee> someMiddleTierCall
			(HttpServletRequest request){
		return (List<Employee>) 
				request.getServletContext().getAttribute("list");
	}



	public void pickDay(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String chosenDay = request.getParameter("selectedDay");
		PrintWriter out = response.getWriter();
		
		// check something
		if(chosenDay.equals("[Monday")){
			throw new 
				IllegalArgumentException("Why would you like Mondays?");
		}
		
		out.println("User picked " + chosenDay);
		// chosenDay=Friday&goodDay=Monday&goodDay=Tuesday
		String[] goodDays = request.getParameterValues("goodDay");
		for(String day : goodDays){
			out.println("You like " + day + ", don't you?");
		}
		
	}
	
	

}




