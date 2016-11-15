package com.revature.java;

public class Objects {

	public static void run(){
		Laptop[] bestBuy = new Laptop[10];
		bestBuy[4] = new Laptop();
		
		System.out.println(bestBuy[4]);
		bestBuy[4].powerOff();
	}
	
	public static void main(String[] args) {
		run();
	}
}
