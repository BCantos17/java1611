package com.revature.jndi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOTest {

	// JAR in classpath:
	// C:\Oracle\Middleware\Oracle_Home\wlserver\
	//			server\lib\weblogic.jar
	public static void main(String[] args) throws SQLException {
		Connection conn = ServiceLocator.getChinookDatabase()
				.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from genre");
		while(rs.next()){
			System.out.println(rs.getString("NAME"));
		}
	}
	
}
