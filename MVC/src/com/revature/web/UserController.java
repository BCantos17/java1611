package com.revature.web;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.middle.BusinessDelegate;
// not a servlet.. just a controller
public class UserController {

	public void login(HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException{
		String user = request.getParameter("j_username");
		String pass = request.getParameter("j_password");
		try {
			User session = 
					new BusinessDelegate().login(user, pass);
			request.getSession().setAttribute("userData", session);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (AuthenticationException e) {
			request.setAttribute("authFailed", "Try to login again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
}
