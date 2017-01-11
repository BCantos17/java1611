package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Game;

public class GameDAO implements DAO {

	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	public void create(Game game) {
		sf.getCurrentSession().save(game);
	}
	@Transactional
	public Game find(int id) {
		return (Game) sf.getCurrentSession().get(Game.class, id);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Game> findAll() {
		return sf.getCurrentSession().createCriteria(Game.class).list();
	}

}
