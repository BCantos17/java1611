package com.revature.exceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionsExample {

	public static void main(String[] args) {
		BufferedReader reader = null; // declare first
		try {
			// Byte stream
/*			FileInputStream fis = 
					new FileInputStream("dan.txt");*/
			// Character Stream
			FileReader fileReader = new FileReader("data.txt"); 
			
			System.out.println("Doesn't run if filenotfound");
			// Line Reader 
			reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			System.out.println("Contents of file: " + line);
			return;
		}catch (FileNotFoundException e) {
			System.out.println("File wasn't found");
		}catch (IOException e){
			System.out.println("Couldn't read the file");
		}catch (Exception e){
			System.out.println("Super generic error message");
		}finally{
			// executes if exception is thrown
			// executes if exception is not thrown
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Application is still running! :)");
	}
	
	public static void write() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("data.txt");
		writer.println("Hello, close method!");	
		writer.print(" always close resources? ");
		writer.print(" yes, please");
		writer.close();
	}
	
}



