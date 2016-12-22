package cukes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.revature.beans.Account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawTest {
	
	private int balance;
	private static List<Account> accounts;
	
	@Given("^I have these accounts$")
	public void i_have_these_accounts(List<Account> list) 
			throws Throwable {
	    accounts = list;
	    System.out.println(accounts);
	}

	@Given("^I have an account$")
	public void regex() throws Throwable {
	    // JUNIT TEST
		
	}

	@Given("^I have (\\d+) dollars$")
	public void abc(int arg1) throws Throwable {
	    balance = arg1;
	}

	@When("^I withdraw (\\d+) dollars$")
	public void pickle(int arg1) throws Throwable {
	   // ACTION
		balance -= arg1;
	}

	@Then("^I have (\\d+) dollars left$")
	public void dan(int arg1) throws Throwable {
	    // OUTCOME
		System.out.println("Remaining balance " + balance);
		assertEquals(arg1, balance);
	}
}
