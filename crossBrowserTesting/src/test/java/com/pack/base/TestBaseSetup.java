package com.pack.base;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.pack.pageObjects.BasePage;
import com.pack.tests.BasePageTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseSetup 
{
	 WebDriver driver;
	 //public ExtentReports report;
	// BasePage basepage;
	 public static ExtentReports extent;
	 public static ExtentTest parent;
	 
	 public WebDriver getDriver() 
	 {
		return driver;
	 }
	 
	 
	   	
		public TestBaseSetup()
		{
			//basepage = new BasePage(driver);
			int ran = new Random().nextInt(9999);

	   		
			extent = new ExtentReports("C:\\Users\\sksatya\\Softwares\\crossBrowserTesting\\Reports\\realmeIndiaReport-"+ran+".html");

			
			
		}
		
		@BeforeTest
		public void runUserChoice() 
		{
			parent = extent.startTest("TestBaseSetup");
		}
	 
	 
	 
	
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) 
	{
		try 
		{
			setDriver(browserType, appURL);

		}
		catch (Exception e) 
		{
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	
	
	public void setDriver(String browserType, String appURL) 
	{
		switch (browserType)
		{
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "edge":
			driver = initFirefoxDriver(appURL);
			break;	
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initChromeDriver(appURL);
		}
	}

	public WebDriver initChromeDriver(String appURL) 
	{
		System.out.println("Launching google chrome ..");
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public WebDriver initFirefoxDriver(String appURL) 
	{
		System.out.println("Launching Firefox browser..");
		driver = WebDriverManager.firefoxdriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	public WebDriver initEdgeDriver(String appURL) 
	{
		System.out.println("Launching google chrome ..");
		driver = WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	
	
	
	
	@AfterClass
	public void closeSetup()
	{

		driver.quit();
		
		//https://www.techbeamers.com/generate-reports-selenium-webdriver/#h3
	}
	
	
	
	@AfterTest
	public void cleanUp()
	{
		extent.endTest(parent);
		extent.flush();
		
	}
}
