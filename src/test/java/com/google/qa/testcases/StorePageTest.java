package com.google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.GmailPage;
import com.google.qa.pages.HomePage;
import com.google.qa.pages.StorePage;
import com.google.qa.util.TestUtil;

public class StorePageTest extends TestBase{
	HomePage homePage;
	GmailPage gmailPage;
	StorePage storePage;
	TestUtil Gm = new TestUtil();
	
	
	public StorePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 homePage = new HomePage();
		 storePage = homePage.ClickonStore();
	}
		 
	
	 @Test(priority = 1)
			public void PhonesDisplayTest() {
				
				Assert.assertTrue(storePage.verifyPhonesText(),Gm.PhoneError);
			}
	 
	 
	 
		@Test(priority = 2)
				public void LaptopDisplayTest() {
			Assert.assertTrue(storePage.verifylaptopText(),Gm.LaptopError);
		
				
		}
		@Test(priority = 3)
		public void StorePageTitleTest() {
			String title = storePage.verifyStoreTitle();
	   Assert.assertEquals(title, Gm.StorePageTitle);

		
}	
				
				@AfterMethod
				public void tearDown() {
					driver.quit();
				}	
				
	
	
	
}
