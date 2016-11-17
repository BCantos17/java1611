package com.revature.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Game {

	public static void main(String[] args) throws Exception {
		dan();
		System.out.println("Complete");
	}
	/**
	 * Deserialize the object from the file
	 * @throws Exception
	 */
	public static void dan() throws Exception{
		Hero hero = new HeroSerialization().load("Bratac");
		System.out.println(hero);
	}
	
	/**
	 * Serialize an object into a file
	 * @throws IOException
	 */
	public static void serialize() throws IOException{
		Hero hero1 = new Hero("Bratac", 99, 2000,
				0, 100000, "Paladin", "Excalibur");
		HeroSerialization serializer = new HeroSerialization();
		serializer.save(hero1);
	}
	
	/**
	 * CSV
	 * @throws FileNotFoundException
	 */
	public static void read() throws FileNotFoundException{
		List<Hero> heroes = new HeroDAO().readHeroes();
		for(Hero h : heroes){
			System.out.println(h);
		}
	}
	
	/**
	 * CSV
	 * @throws FileNotFoundException
	 */
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
