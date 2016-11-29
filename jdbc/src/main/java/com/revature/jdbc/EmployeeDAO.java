package com.revature.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class EmployeeDAO {
	
	public int youngEmployees() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager
				.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"chinook",
						"chinook");
		int result = 0; // to store returned value
		CallableStatement stmt = conn
				.prepareCall("{ ? = call YOUNG_EMPLOYEES() }");
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();
		result = stmt.getInt(1);
		conn.close();
		return result;
	}

	public String getFullName(int id) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager
				.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"chinook",
						"chinook");
		String fullname = ""; // OUT param
		// call procedure
		CallableStatement stmt = conn
				.prepareCall("call employee_fullname(?, ?)");
		stmt.setInt(1, id); // bind IN param
		stmt.registerOutParameter(2, Types.VARCHAR);
		stmt.execute();
		fullname = stmt.getString(2); // extract the OUT param
		conn.close();
		return fullname;
	}
	
}
