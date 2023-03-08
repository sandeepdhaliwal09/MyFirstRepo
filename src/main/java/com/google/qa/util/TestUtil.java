package com.google.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.qa.base.TestBase;
import com.google.qa.config.Xls_Reader;



public class TestUtil extends TestBase{
	
	Xls_Reader d = new Xls_Reader("/Users/sandeepdhaliwal/Desktop/QA/SeleniumWorkSpace/GoogleTest/src/main/java/com/google/qa/testdata/GoogleTestData.xlsx");
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	
	//Xls_Reader d = new Xls_Reader("/Users/sandeepdhaliwal/Documents/NikulTest.xls");
	
	public String GmailTitle = d.getCellData("google", "Title", 2);
	public String HelpTitle = d.getCellData("google", "Title", 4);
	public String StorePageTitle = d.getCellData("google", "Title", 5);
	public String GmailTitleError = d.getCellData("google", "Error", 2);
	public String GmailAccounterror = d.getCellData("google", "Error", 3);
	public String HelpTitleError =	 d.getCellData("google", "Error", 4);
	public String PhoneError = d.getCellData("google", "Error", 5);
	public String LaptopError = d.getCellData("google", "Error", 6);
    public String GoogleTitle = d.getCellData("google","Title",7);
		
    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	




	
	

}
