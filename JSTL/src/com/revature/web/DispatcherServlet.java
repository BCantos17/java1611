package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Department;
import com.revature.beans.Employee;

public class DispatcherServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// custom initialization logic
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Department sales = new Department("Sales", 1_000_000);
		Employee don = new Employee("Donald","Trump", sales, null);
		
		employees.add(don);
		employees.add(new Employee("Dan", "Pickles", sales, don));
		employees.add(new Employee("Howard", "Johnson", sales, don));
		employees.add(new Employee("alert('Randolph Scott!');",
					"alert('Randolph Scott!');", sales, don));
		
		// put something into application scope
		this.getServletContext().setAttribute("list", employees);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		switch(requestURI){
			case "/JSTL/employees.do":{
				new EmployeeController().doAll(request, response);			
				break;
			}
			default:{
				response.setStatus(404);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
