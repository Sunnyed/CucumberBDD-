package com.Stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.driverFactory.DriverFactory;
import com.pages.AccountPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageStep {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable creddata) {
		
		List<Map<String, String>> credList = creddata.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLoginPage(userName, passWord);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	  
		String pgtitle = accountPage.getAccountPageTitle();
		System.out.println(pgtitle);
		
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionData) {
		
		List<String> expectedsectionList  = sectionData.asList();
		System.out.println("expected sectionList is " + expectedsectionList);
		
		List<String> actualSectionList = accountPage.getaccountSectionList();
		System.out.println("Actual sectionList is " + actualSectionList);
		
		Assert.assertTrue(expectedsectionList.containsAll(actualSectionList));
	   
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	  Assert.assertTrue(accountPage.getaccountSectionsCount() == expectedSectionCount);
	}

}
