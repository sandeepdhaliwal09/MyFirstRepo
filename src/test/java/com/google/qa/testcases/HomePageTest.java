package com.google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.HomePage;
import com.google.qa.pages.SearchPage;
import com.google.qa.util.TestUtil;
import com.google.qa.pages.GmailPage;
public class HomePageTest extends TestBase{
	 
	HomePage homePage;
	SearchPage SearchPage;
	GmailPage gmailPage;
	TestUtil Gm = new TestUtil();
	public void setup2() {
		
	}
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 homePage = new HomePage();
		 
	 }
	
	  
			
	
	@Test(priority = 1 )
	public void HomePagetitleTest() {
		String title = homePage.validateHomePagetitle();
		Assert.assertEquals(title,Gm.GoogleTitle );
	}
	@Test(priority = 2)
		public void GooogleImageLogoTest() {
		boolean flag = homePage.validateGooglelogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void SearchPageTest() {
		SearchPage = homePage.search(prop.getProperty("search"));
		
	}
	
	@Test(priority = 4)
	public void GmailPageTest() {
		gmailPage = homePage.Signin();
		
	}
	
		@Test (priority = 5)
		public void VerifyStoreLinkTest() {
			homePage.ClickonStore();
		}
		
		
		
	
	
	
	
@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
	
	
}
