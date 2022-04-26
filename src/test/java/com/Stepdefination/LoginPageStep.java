package com.Stepdefination;

import com.driverFactory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageStep {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getPageTitle();
		System.out.println("Page Title is " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));

	}

	@Then("forget your passowrd link should be displayed")
	public void forget_your_passowrd_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPasswordLinkExits());
	
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) {
		loginPage.enterUserName(username);
	    
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String pwd) {
		loginPage.enterpassword(pwd);
	    
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		loginPage.clickOnLogin();
	   
	}

	
}
