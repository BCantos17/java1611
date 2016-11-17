package com.revature.exceptions;

public class BankingApplication {
	double accountBalance = 1000;

	/**
	 * Takes a positive number and withdraws that amount
	 * from your account balance. User cannot supply a 
	 * negative number.. duh
	 * @param funds
	 * @throws InsufficientFundsException if users doesn't have enough money
	 */
	public void withdraw(double funds) 
			throws InsufficientFundsException{ // declares
		// validation
		if(funds < 0)
			// unchecked exception: no try/catch required
			throw new IllegalArgumentException();
		
		
		if(funds > accountBalance)
			// checked exception: compiler forces try/catch
			throw new InsufficientFundsException(); // actually throws
		System.out.println("Withdrawing $" + funds);
		
	}
	
	// Banks calls my code
	public static void main(String[] args) {
		BankingApplication atm = new BankingApplication();
		try {
			atm.withdraw(-100_000_000_000_000.00);
			System.out.println("Here's your money");
		} catch (InsufficientFundsException e) {
			System.out.println("You don't have enough cash");
		}
	}
	
}






