package com.revature.jndi;

public class MiddleTier {

	public static void main(String[] args) {
		DAOFacade dataLayer = new DAOFacade();
		dataLayer.freshTalent(9001, "Lamb of God",
				7777, "Sacrament");
		System.out.println("Complete");
	}
	
}
