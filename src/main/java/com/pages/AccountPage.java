package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;
	
	//1, By locators
	private By accountSections = By.xpath("//div[@id = 'center_column']/div/div/ul/li/a/span");

	
	//2. Constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Actions-- What exactly you want to perform here
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getaccountSectionsCount()
	{
	 return driver.findElements(accountSections).size();
	}
	
	public List<String> getaccountSectionList()
	{
		List<String> accountlist = new ArrayList<>();
		List<WebElement> accountheaderList = driver.findElements(accountSections);
		for(WebElement e : accountheaderList)
		{
			String list = e.getText();
			System.out.println(list);
			accountlist.add(list);
		}
		return accountlist;
		
	}
	
	
}
