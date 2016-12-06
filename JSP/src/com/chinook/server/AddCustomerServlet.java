package com.chinook.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customerId"));
		String first = req.getParameter("firstName");
		String last = req.getParameter("lastName");
		String email = req.getParameter("email");
		Customer customer = new Customer(id, first, last, email);
		// insert into database
/*		CustomerDAO dao = new CustomerDAO();
		dao.insert(customer);*/
		
		// upon success, prepare the view 
			// scope: (application, session, request, page)
		// then send them to a homepage
		req.setAttribute("me", customer); // data available on next page
		req.getRequestDispatcher("customerHome.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}




