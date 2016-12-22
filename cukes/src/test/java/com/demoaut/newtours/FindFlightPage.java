package com.demoaut.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindFlightPage {

	private WebDriver driver;
	private String oneWay = "input[name=tripType][value=oneway]";
	private String passengerCount = "passCount";
	
	public FindFlightPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void selectOneWay(){
		driver.findElement(By.cssSelector(oneWay)).click();
	}
	
	public void selectPassengers(int passengers){
		Select passengerSelectBox = 
				new Select(driver.findElement(
						By.name(passengerCount)));
		passengerSelectBox.selectByValue(Integer.toString(passengers));
	}
	
	public void selectDepartingLocation(String from){
		new Select(driver.findElement(By.name("fromPort")))
					.selectByVisibleText(from);
	}
	
	public void clickFindFlightsButton(){
		driver.findElement(By.name("findFlights")).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}







