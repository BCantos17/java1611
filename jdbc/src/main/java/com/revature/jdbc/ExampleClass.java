package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class ExampleClass {
	
	public static void bad(String[] args) throws Exception{
		// register driver
		Class.forName("oracle.jdbc.OracleDriver");
		// create connection
		Connection conn = DriverManager
				.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"chinook",
						"chinook");
		// make object to save
		Genre genre = new Genre(); 
		genre.setName("a'); drop table "
				+ "playlisttrack; --");
		// generate sql
		String sql = "INSERT INTO GENRE(NAME) VALUES ('";
		sql += genre.getName() + "' )";
		// execute the SQL statement
		Statement stmt = conn.createStatement(); 
		stmt.executeUpdate(sql); 
		System.out.println("Success!");
	}

	public static void main(String[] args) throws Exception {
		GenreDAO dao = new GenreDAOImpl();

		Genre genre = new Genre(984562,
				"a'); drop table playlisttrack; --");
		dao.insert(genre);
		dao.close();
		System.out.println("Confirmed!");
	}

	
	
}
