package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demoaut.newtours.FindFlightPage;
import com.demoaut.newtours.LoginPage;

public class NewToursLoginTest {
	
	private WebDriver driver;
	
	@Before
	public void makeDriver(){
		String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",
				PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	@Test
	public void test(){
		// Notice the absence of Selenium code
		LoginPage page = new LoginPage(driver);
		// Page opened?
		org.junit.Assert.assertEquals("Welcome: Mercury Tours",
				page.getPageTitle());
		// Interact with page .. without Selenium code!
		page.setUsername("a");
		page.setPassword("a");
		FindFlightPage findFlight = page.clickLoginButton();
		
		// Made it to next page?
		org.junit.Assert.assertEquals("Find a Flight: Mercury Tours:",
				findFlight.getPageTitle());
		findFlight.selectOneWay();
		findFlight.selectPassengers(2);
		findFlight.selectDepartingLocation("New York");
		findFlight.clickFindFlightsButton();
		
		// Made it to next page?
		org.junit.Assert.assertEquals("Select a Flight: Mercury Tours",
						driver.getTitle());
		
	}
	
	@After
	public void quit(){
		driver.quit();
	}
	
}






