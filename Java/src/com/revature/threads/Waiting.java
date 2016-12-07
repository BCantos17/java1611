package com.revature.threads;

import java.text.NumberFormat;

public class Waiting {
	
	int accountBalance = 1_000;
	
	public synchronized void deposit(){
		this.accountBalance += 1_000;
	}
	public synchronized void withdraw(){
		this.accountBalance -= 1_000;
	}
	

	public static void main(String[] args) throws InterruptedException {
		Waiting account = new Waiting();
		
		//anonymous class
		Thread parent = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1000; i++){
					account.deposit();
				}
			}
		});
		
		Thread kid = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1000; i++){
					account.withdraw();
				}
			}
		});
		parent.start();
		kid.start();
		
		parent.join();
		kid.join();
		System.out.println("Account balance is: "
					+ NumberFormat.getCurrencyInstance()
						.format(account.accountBalance));
		
	}
	
}

