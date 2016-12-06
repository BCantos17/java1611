package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class HelloServlet extends HttpServlet{
	
	/**
	 * Load DataSource from JNDI lookup
	 */
	@Resource(name="datasource/chinook")
	private DataSource chinook;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGET method");
		this.doPost(req, resp);
	}

	/**
	 * Handles HTTP Post requests.
	 * This method is invoked by servlet container
	 * when a Post request is sent to this servlet's
	 * url-pattern.. as declared in web.xml
	 */
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp)
					throws ServletException, IOException {
		
		// DAO call
		try {
			Connection conn = chinook.getConnection();
			// logic to check if the user exists.
			// get userid and pass from HTTP message
			int id = Integer.parseInt( req.getParameter("userid") );
			String password = req.getParameter("pass");

			String sql = "select employeeid, email"
					+ " from employee where employeeid = ? and "
					+ "email = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			boolean gotResult = rs.next();
			
			// if exists, they goto homepage
			if(gotResult){
				/*PrintWriter out = resp.getWriter();
				out.println("<html><body> Homepage! Hello, User "
						+id+ "</body></html> ");*/

				// move to another page
				req.getRequestDispatcher("home.html")
					.forward(req, resp);
				
			}
			// if not, they get a fail page
			else{
				/*PrintWriter out = resp.getWriter();
				out.println("<html><body> You fail @ logging in "
						+ "</body></html>");*/
				
				// tells browser to goto the following page
				resp.sendRedirect("fail.html");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}





