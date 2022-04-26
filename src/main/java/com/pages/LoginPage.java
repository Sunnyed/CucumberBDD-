package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators

	By emailId = By.id("email");
	By password = By.id("passwd");
	By signInButton = By.id("SubmitLogin");
	By forgotPasswordlink = By.linkText("Forgot your password?");

	// 2. Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions

	public String getPageTitle() {
		return driver.getTitle();
	}

	public Boolean isForgotPasswordLinkExits() {
		return driver.findElement(forgotPasswordlink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterpassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountPage doLoginPage(String uname, String passwrd)
	{
		driver.findElement(emailId).sendKeys(uname);
		driver.findElement(password).sendKeys(passwrd);
		driver.findElement(signInButton).click();
		
		return new AccountPage(driver);
	}
}
