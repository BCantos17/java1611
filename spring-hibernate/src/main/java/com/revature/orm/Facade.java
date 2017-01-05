package com.revature.orm;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Card;

public class Facade {

	private DAO dao;
	public void setDao(DAO dao) {this.dao = dao;}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
					rollbackFor=Exception.class,
					propagation=Propagation.REQUIRES_NEW)
	public void insertDeck(List<Card> deck) throws InterruptedException{
		for(Card c : deck){ 
			if(Math.random() > 0.99) throw new RuntimeException();
			dao.insert(c);
			System.out.println("Card inserted.. (uncommited)");
		}
	}
}







