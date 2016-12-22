package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * Selenium WebDriver 
 * 	Automate your testing!
 * 
 *  http://newtours.demoaut.com/
 *
 */
public class HelloSelenium {

	public static void main(String[] args) {
		String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
		String URL = "http://www.revature.com";
		
		System.setProperty("webdriver.chrome.driver",
				PATH_TO_CHROME_DRIVER);
		WebDriver driver = new ChromeDriver();
		
		// open the browser and navigate to URL
		driver.get(URL); 
		
		// Click the RevaturePRO link
		String X_PATH = "//*[@id=\"menu-item-234\"]/a";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.click(); // clicks the link or button
		
		// driver.close(); will only close browser
		
		// "pause" the automation test
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Kills the driver process and closes browser
		//driver.quit();
		
	}
	
}






