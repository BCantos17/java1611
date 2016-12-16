package com.revature.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.revature.beans.Trainee;
import com.revature.beans.Trainees;

public class TraineeDAO{

	private Connection getConnection(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"demo", "demo");
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Could not connect to DB.. returning null");
			return null;
		}
	}
	
	public void insert(Trainee trainee){
		Connection conn = getConnection();
		try {
			String sql = "insert into trainee(trainee_name, major) values (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, trainee.getName());
			stmt.setString(2, trainee.getMajor());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Trainee trainee){
		Connection conn = getConnection();
		try {
			String sql = "update trainee set trainee_name=?, major=? where trainee_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, trainee.getName());
			stmt.setString(2, trainee.getMajor());
			stmt.setInt(3, trainee.getId());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Trainee trainee){
		Connection conn = getConnection();
		try {
			String sql = "delete from trainee where trainee_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, trainee.getId());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Trainee getById(int id){
		Connection conn = getConnection();
		Trainee trainee = null;
		try {
			String sql = "select trainee_id, trainee_name, major from trainee where trainee_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				trainee = new Trainee(rs.getInt("trainee_id"),
					rs.getString("trainee_name"), rs.getString("major"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainee;
	}

	public Trainees getAll(){
		Connection conn = getConnection();
		Trainees trainees = new Trainees();
		trainees.setTrainees(new HashSet<Trainee>());
		try {
			String sql = "select trainee_id, trainee_name, major from trainee";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Trainee trainee = new Trainee(rs.getInt("trainee_id"),
					rs.getString("trainee_name"), rs.getString("major"));
				trainees.getTrainees().add(trainee);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainees;
	}	
}
