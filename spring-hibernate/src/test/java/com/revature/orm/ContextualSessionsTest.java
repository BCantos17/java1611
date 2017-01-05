package com.revature.orm;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Card;

public class ContextualSessionsTest {

	private static ApplicationContext contxt;
	@BeforeClass
	public static void setup(){
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void testRollback(){
		List<Card> deck = new ArrayList<Card>();
		for(int i=0; i<10000; i++)
			deck.add(new Card("Spade", 14));
		try {
			contxt.getBean(Facade.class).insertDeck(deck);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void create(){
		contxt.getBean(DAO.class).insert(new Card("Spades", 10));
		System.out.println("Success!");
	}
}





