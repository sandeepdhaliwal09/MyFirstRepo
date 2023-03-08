package com.google.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.qa.base.TestBase;

public class GmailPage  extends TestBase{
	
	
	@FindBy(id = "identifierId")
	WebElement  email;
	
	@FindBy(id = "identifierNext")
	WebElement Next;
	
	@FindBy(className ="o6cuMc")
	WebElement GoogleError;
	
	@FindBy(linkText = "Help")
	WebElement Help;
	
	@FindBy (linkText = "Store")
	WebElement Store;
	
	
	public GmailPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateGmailPagetitle() {
		return driver.getTitle();
	}
	
	public void VerifyGmailError(String a) {
		email.sendKeys(a);
		Next.click();
		
	}
	
   public String GmailError() {
		

		String actualErr = GoogleError.getText();
		
		return actualErr;
}
	public String HelpClick() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		Set<String> allWindows = driver.getWindowHandles();;
		
		Help.click();
		
		allWindows =  driver.getWindowHandles();
		
		
		Iterator<String> iter = allWindows.iterator();
		 iter.next();
		String childWindow = iter.next();
		
		Thread.sleep(2000);
		
		
		driver.switchTo().window(childWindow);
		
		return driver.getTitle();
	}
	

	}
