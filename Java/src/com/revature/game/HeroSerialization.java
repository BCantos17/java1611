package com.revature.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HeroSerialization {

	/**
	 * Serialize hero and save to binary file
	 * with the name "heroname.ser"
	 * Java Object --> binary data
	 * @param hero
	 * @throws IOException 
	 */
	public void save(Hero hero) throws IOException{
		// ObjectOutputStream converts Object to bytes
		// FileOutputStream outputs the bytes to File
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new FileOutputStream(
								new File(hero.getName() + ".ser")));
		out.writeObject(hero);
	}
	
	/**
	 * Deserialize hero and load into memory
	 * Binary Data --> Java object
	 * @param hero
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Hero load(String hero) throws ClassNotFoundException, IOException{
		// FileInputStream reads bytes from File
		// ObjectInputStream converts bytes to Object's variables
		ObjectInputStream out = 
				new ObjectInputStream(
						new FileInputStream(
								new File(hero + ".ser")));
		// don't forget to cast
		return (Hero) out.readObject();
	}
	
}
