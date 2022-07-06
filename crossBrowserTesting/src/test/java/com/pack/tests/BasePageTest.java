package com.pack.tests;

	import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.pack.base.TestBaseSetup;
	import com.pack.pageObjects.BasePage;
import com.relevantcodes.extentreports.ExtentTest;  // for extent report
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import com.pack.base.TestBaseSetup;
//import testBatches.TestBatches;

import com.pack.pageObjects.BasePage;
//import testBatches.TestBatches;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

	public class BasePageTest extends TestBaseSetup
	{
		
		WebDriver driver;
		BasePage basePage;
		ExtentTest child;
		
		
		
		
//		public void setUp(WebDriver driver) 
//		{
//			this.driver = driver;
//		}
		
	
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		
		
		boolean result;
		public void logReport(boolean flag,String stepName)	// Extent child and logReport
		{													// child = TestBatches.extent.strtTest 
			if(flag)										// TestBatches.parent.appendChild(child)
			{
				child.log(LogStatus.PASS, stepName,"Successfull");
			}
			else
			{
				child.log(LogStatus.FAIL, stepName,"Fail");
			}
		}
		
	
		
		
		@Test
		(priority=1)
		public void verifyHomePage() 
		{
			basePage = new BasePage(driver);
			
			child = TestBaseSetup.extent.startTest("verifyHomePage");
			TestBaseSetup.parent.appendChild(child);
			
			System.out.println("1");
			System.out.println("Home page test...");
			//basePage = new BasePage(driver);
			//Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
			//basePage.verifyBasePageTitle();
			
			logReport(basePage.verifyBasePageTitle(),"Verify Base Page");
		}
		
		@Test
		(priority=3)
		public void scroll() throws InterruptedException
		{
			
			basePage = new BasePage(driver);
			System.out.println("Scrolling");
			
			child = TestBaseSetup.extent.startTest("scroll");
			TestBaseSetup.parent.appendChild(child);
			
		//	basePage.scrollBy();
			logReport(basePage.scrollBy(),"Scroll By");

		}
		
		@Test
		(priority=2)
		public void clickApp() throws InterruptedException
		{
			
			basePage = new BasePage(driver);
			System.out.println("Clicking on App Tab");
			
			child = TestBaseSetup.extent.startTest("clickApp");
			TestBaseSetup.parent.appendChild(child);
			
//			basePage.clickAppTab();
			logReport(basePage.clickAppTab(),"clickAppTab");
		}
		
		@Test
		(priority=4)
		public void nextElement() throws InterruptedException
		{
			basePage = new BasePage(driver);
			
			child = TestBaseSetup.extent.startTest("nextElement");
			TestBaseSetup.parent.appendChild(child);
			
			//basePage.nextElement();
			logReport(basePage.nextElement(),"next Element");

		}
		
	}

