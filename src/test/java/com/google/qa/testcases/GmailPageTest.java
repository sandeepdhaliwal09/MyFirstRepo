package com.google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.GmailPage;
import com.google.qa.pages.HomePage;
import com.google.qa.util.TestUtil;

public class GmailPageTest extends TestBase{
	
	HomePage homePage;
	GmailPage gmailPage;
	TestUtil Gm = new TestUtil();
	
	public GmailPageTest() {
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		homePage = new HomePage();
		gmailPage = homePage.Signin();
	}
	
	
	
	@Test(priority = 1)
	public void GmailPagetitleTest() {
		
		String title = gmailPage.validateGmailPagetitle();
		
		
		Assert.assertEquals(title, Gm.GmailTitle, Gm.GmailTitleError);
	}
	
	
	@Test(priority = 2)
	public void GmailErrorTest() {
		
		
		gmailPage.VerifyGmailError(prop.getProperty("username"));
		
		Assert.assertEquals(gmailPage.GmailError(), Gm.GmailAccounterror); 
	}
	
	
	
	@Test(priority = 3)
	public void HelpPageTitleTest() throws InterruptedException {
		
		
		String title = gmailPage.HelpClick();
		
		Assert.assertEquals(title, Gm.HelpTitle, Gm.HelpTitleError);
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
