package com.revature.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "chinook";
	// private static final String YOURS = "p4ssw0rd";
	public static final String PASS = "chinook";

	public void close() throws SQLException;
	
	// create
	public void insert(Genre genre) throws SQLException;
	// retrieve
	public List<Genre> query(String like) throws SQLException;
	
	
	
	/**
	 * public Genre get(int pk); public List<Genre> getall(); public List
	 * <Genre> query(String like);
	 */
	// update
	/**
	 * public void update(Genre genre);
	 */
	// delete
	/**
	 * public void delete(Genre genre); public void delete(int pk);
	 */

}
