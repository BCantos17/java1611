package com.revature.game;

import java.io.FileNotFoundException;
import java.util.List;

public class Game {

	public static void main(String[] args) throws FileNotFoundException {
		read();
		//System.out.println("Complete!");
	}
	
	public static void read() throws FileNotFoundException{
		List<Hero> heroes = new HeroDAO().readHeroes();
		for(Hero h : heroes){
			System.out.println(h);
		}
	}
	
	public static void create() throws FileNotFoundException{
		Hero hero1 = new Hero("Bratac", 99, 2000,
				0, 100000, "Paladin", "Excalibur");
		Hero hero2 = new Hero("Preude", 99, 1700, 1250, 100000,
				"Red Mage", "Joyeuse");
		Hero hero3 = new Hero("Dan Pickles", 99, 3000, 0, 999999,
				"Samurai", "Katana");
		
		HeroDAO dao = new HeroDAO();
		// save the state of my party of players
		dao.createHeroCSV(hero1);
		dao.createHeroCSV(hero2);
		dao.createHeroCSV(hero3);
	}
}
