package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl implements GenreDAO{
	
	private Connection conn;
	/**
	 * 	Establish connection to database
	 */
	public GenreDAOImpl() throws Exception{
		// as JDBC 4.0, this isn't needed
		// forces class to be loaded into JVM
		Class.forName("oracle.jdbc.OracleDriver");
		// makes connection to database
		conn = DriverManager.getConnection(URL, USER, PASS);
	}

	public void insert(Genre genre) throws SQLException {
/*		
  		Statement: compiled by the database
  		PreparedStatement: compiled by Java
  		
  		String sql = "INSERT INTO GENRE(NAME) VALUES ('";
		
		sql += genre.getName() + "' )";

		Statement stmt = conn.createStatement(); //factory
		stmt.executeUpdate(sql); */
												// ? = parameter 
		String sql = "INSERT INTO GENRE VALUES (?,?)";
		PreparedStatement stmt = conn
											// columns return by stmt.getGeneratedKeys
				.prepareStatement(sql, new String[]{"genreid"});
		// bind values to ? params
		stmt.setString(2, genre.getName());
		stmt.setInt(1, genre.getId());
		stmt.executeUpdate(); //executes insert stmt, trigger fires
		
		// get the generated values
		ResultSet rs = stmt.getGeneratedKeys();
		// goto the first row
		rs.next();
		// get the value
		int generatedPK = rs.getInt(1);
		// update my in-memory object
		genre.setId(generatedPK);
	}

	public void close() throws SQLException{
		conn.close();
	}

	public List<Genre> query(String like) throws SQLException {
		// stores all the rows from the query
		List<Genre> results = new ArrayList<Genre>();
		// construct query
		String sql = "SELECT GENREID, NAME FROM GENRE WHERE "
				+ "NAME LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// pass in the param
		stmt.setString(1, "%"+like+"%");
		// ResultSet contains rows returned by query
		ResultSet rs = stmt.executeQuery();
		// convert ResultSet into a Java List
		mapRows(rs, results);	
		return results;
	}

	private void mapRows(ResultSet rs, List<Genre> results) 
			throws SQLException {
		while(rs.next()){
			// get values from row
			int id = rs.getInt("GENREID");
			String name = rs.getString("NAME");
			// create object using those values
			Genre obj = new Genre(id, name);
			// add object to list
			results.add(obj);
		}
	}
}
