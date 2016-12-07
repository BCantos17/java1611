package com.revature.jdbc;

import java.sql.SQLException;

public class ProcedureTest {

	public static void main(String[] args) throws Exception, SQLException {
		EmployeeDAO dao = new EmployeeDAO();
		int youngEmployees = dao.youngEmployees();
		System.out.println(youngEmployees);
		
	}
	
}
