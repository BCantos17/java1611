package cukes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demoaut.newtours.FindFlightPage;
import com.demoaut.newtours.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class NewToursTest {

	private static WebDriver driver;
	private static LoginPage loginPage;
	private static FindFlightPage findFlightPage;
	
	/**
	 * @see before() method
	 */
	private static boolean lastTest = false;
	
	/**
	 *  Initialize when tests start
	 *  Cucumber does not have support for BeforeClass.
	 *  @Before and @After execute for each Scenario.
	 *  So, you must have flags to indicate whether to
	 *  	run the code or not. A bit messy, but
	 *  	Cucumber has decided not to implement this feature:
	 *  	https://github.com/cucumber/cucumber-jvm/pull/295
	 */
	@cucumber.api.java.Before
	public static void before(){
		// do only once
		if(driver == null){
			String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	/**
	 * @see before() method
	 */
	@cucumber.api.java.After
	public static void after(){
		if(lastTest)
			driver.quit();
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
		loginPage = new LoginPage(driver);
		assertEquals("Welcome: Mercury Tours",
				loginPage.getPageTitle());
	}

	@Given("^I enter \"([^\"]*)\" as the username$")
	public void i_enter_as_the_username(String arg1) throws Throwable {
		loginPage.setUsername(arg1);
	}

	@Given("^I enter \"([^\"]*)\" as the password$")
	public void i_enter_as_the_password(String arg1) throws Throwable {
		loginPage.setPassword(arg1);
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		findFlightPage = loginPage.clickLoginButton();
	}

	@Then("^I will be on the find flight page$")
	public void i_will_be_on_the_find_flight_page() throws Throwable {
		org.junit.Assert.assertEquals("Find a Flight: Mercury Tours:",
				findFlightPage.getPageTitle());
	}

	@Given("^I am on the find flight page$")
	public void i_am_on_the_find_flight_page() throws Throwable {
		org.junit.Assert.assertEquals("Find a Flight: Mercury Tours:",
				findFlightPage.getPageTitle());
	}

	@Given("^I select one-way flight$")
	public void i_select_one_way_flight() throws Throwable {
		findFlightPage.selectOneWay();
	}

	@Given("^I select (\\d+) passengers$")
	public void i_select_passengers(int arg1) throws Throwable {
		findFlightPage.selectPassengers(arg1);
	}

	@Given("^I select \"([^\"]*)\" as departing location$")
	public void i_select_as_departing_location(String arg1) throws Throwable {
		findFlightPage.selectDepartingLocation(arg1);
	}

	@When("^I click continue button$")
	public void i_click_continue_button() throws Throwable {
		findFlightPage.clickFindFlightsButton();
	}

	@Then("^I will be on the select flight page$")
	public void i_will_be_on_the_select_flight_page() throws Throwable {
		org.junit.Assert.assertEquals("Select a Flight: Mercury Tours",
				driver.getTitle());
		/*
		 * Done testing
		 */
		lastTest = true;
	}

}
