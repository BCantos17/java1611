package com.revature.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Data access object will perform CRUD
 *  (create retrieve update delete)
 *  operations on hero data using text files.
 * @author Owner
 *
 */
public class HeroDAO {

	/**
	 * Save the Hero into 
	 * Comma-separated value file in the format:
	 * name,level,hp,mp,xp,clazz,weapon
	 * @throws FileNotFoundException 
	 */
	public void createHeroCSV(Hero hero) throws FileNotFoundException{
		PrintWriter writer = null;
		try{
			File file = new File("heroes.txt");
			writer = new PrintWriter(
					new FileOutputStream(file, true));
			StringBuilder csv = new StringBuilder();
			csv.append(hero.getName()).append(",")
				.append(hero.getLevel()).append(",")
				.append(hero.getHitPoints()).append(",")
				.append(hero.getManaPoints()).append(",")
				.append(hero.getExperiencePoints()).append(",")
				.append(hero.getClazz()).append(",")
				.append(hero.getWeapon()).append("\n");
			writer.print(csv);
		}finally{
			writer.close();
		}
	}
	
	public List<Hero> readHeroes() throws FileNotFoundException{
		ArrayList<Hero> heroes = new ArrayList<Hero>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File("heroes.txt"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()){
				Hero hero = new Hero(scanner.next(),
								Integer.parseInt(scanner.next()),
								Integer.parseInt(scanner.next()),
								Integer.parseInt(scanner.next()),
								Integer.parseInt(scanner.next()),
								scanner.next(),
								scanner.next());
				heroes.add(hero);
			}// EOF
			return heroes;
		}finally{
			scanner.close();
		}
	}
}







