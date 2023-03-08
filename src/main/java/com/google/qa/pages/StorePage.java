package com.google.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class StorePage extends TestBase{

	@FindBy(linkText = "Phones")
	WebElement  phones;
	
	@FindBy(linkText = "Laptops")
	WebElement laptop;
	
	
	
	public StorePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPhonesText() {
		return phones.isDisplayed();
	}
	public boolean verifylaptopText() {
		return laptop.isDisplayed();
	}
	public String verifyStoreTitle() {
		return driver.getTitle();
	}
}
