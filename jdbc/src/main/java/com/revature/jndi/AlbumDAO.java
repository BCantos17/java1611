package com.revature.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlbumDAO {

	private Connection conn;
	public AlbumDAO(Connection conn) {
		super();
		this.conn = conn;
	}
						// definitely use an object here....
	public void insert(int albumId, String title, int artistId) throws SQLException{
		String sql = "insert into album values (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, albumId);
		stmt.setString(2, title);
		stmt.setInt(3, artistId);
		stmt.executeUpdate();
	}
	
}




