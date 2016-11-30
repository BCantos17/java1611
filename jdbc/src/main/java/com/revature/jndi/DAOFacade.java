package com.revature.jndi;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFacade {

	public void freshTalent(int artistId, String name,
			int albumId, String title) {
		Connection conn = null;
		try {
			conn = ServiceLocator.getChinookDatabase().getConnection();
			conn.setAutoCommit(false); // enables transaction
			// new artist
			new ArtistDAO(conn).insert(artistId, name);
			// new hit album
			new AlbumDAO(conn).insert(albumId, title, artistId);
			// one transaction
			conn.commit(); // a-okay
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
