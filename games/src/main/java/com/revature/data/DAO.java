package com.revature.data;

import java.util.List;

import com.revature.beans.Game;

public interface DAO {

	public void create(Game game);
	public Game find(int id);
	public List<Game> findAll();
	
}
