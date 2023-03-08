package com.google.qa.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.qa.util.TestUtil;
import com.google.qa.util.WebEventListener;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
		
		FileInputStream f = new FileInputStream ("/Users/sandeepdhaliwal/Desktop/QA/SeleniumWorkSpace/GoogleTest/src/main/java/com/google/qa/config/cofig.properties");
		 prop = new Properties();
		prop.load(f);
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Firefox")) {
			 driver = new FirefoxDriver();
		}else if(browserName.equals("Chrome")){
			 driver = new ChromeDriver();
		}else {
			 driver = new SafariDriver();
			
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	
	
	
	

}
