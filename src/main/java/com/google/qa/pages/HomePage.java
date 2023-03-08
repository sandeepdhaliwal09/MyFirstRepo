package com.google.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class HomePage extends TestBase{
     
	
	
	@FindBy(className = "gLFyf")
	WebElement Searchbox;
	
	@FindBy(name = "btnK")
	WebElement Searchbtn;
	
	@FindBy (linkText = "Sign in")
	WebElement Signinbtn;
	
	@FindBy (linkText = "Store")
	WebElement Store;
	
	@FindBy (xpath = "//img[@class='lnXdpd']")
	WebElement glogo;
	//initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	//actions
	public String validateHomePagetitle() {
		return driver.getTitle();
	}
	public boolean validateGooglelogo() {
		return glogo.isDisplayed();
	}
	public SearchPage search(String m) {
		Searchbox.sendKeys(m + Keys.ENTER);
		//Searchbtn.click();;
		
		return new SearchPage();
	}
	public GmailPage Signin() {
		
		Signinbtn.click();;
		
		return new GmailPage();
}
	public StorePage ClickonStore() {
		Store.click();
		return new StorePage();
	}
}