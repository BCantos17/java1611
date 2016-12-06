package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*") // takes HTTP requests
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		// "/MVC/login" "/MVC/insertReimb"
		UserController userCtrl = new UserController();
		switch (requestURI) {
			case "/MVC/user/login": {
				userCtrl.login(req, resp);
				break;
			}
			/*case "/MVC/user/register": {
				userCtrl.registerUser(req, resp);
				break;
			}
			case "/MVC/user/delete": {
				userCtrl.deleteUser(req, resp);
				break;
			}*/
			default:{
				resp.setStatus(404);
				resp.sendRedirect("oops.html");
			}
		}
	}
}
