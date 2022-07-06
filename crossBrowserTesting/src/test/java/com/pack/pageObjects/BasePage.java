package com.pack.pageObjects;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeTest;

import com.pack.tests.BasePageTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import testScenarios.TestCases;




public class BasePage 
{
	
	WebDriver driver ;
	BasePageTest basepagetest;
	 
	
	
	
	//private By signInButton = By.linkText("Sign in");
	
	@FindBy(xpath = "(//label[text()='Login'])[1]") WebElement loginBtnElement;
	@FindBy(xpath = "(//a[text()='App'])") WebElement clickApp;
	
	
	
	
	
	
	
	
	public BasePage(WebDriver driver) 
	{
		basepagetest = new BasePageTest();
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		//basepagetest = new BasePageTest();   //since we are using testCases methods that's why 
		//we have to create object of testCases
		//int ran = new Random().nextInt(9999);

		//extent = new ExtentReports("C:\\Users\\sksatya\\Softwares\\crossBrowserTesting\\Reports\\realmeIndiaReport-"+ran+".html");


	}
	
	
	
	
	
	
	
	
	public LoginPage clickLoginInBtn() throws InterruptedException 
	{
		System.out.println("Clicking on Log in button");
		//WebElement loginBtnElement=driver.findElement(loginBtnElement);
		if(loginBtnElement.isDisplayed()||loginBtnElement.isEnabled())
		{
			System.out.println("Login Button is Enabled or Displayed");
			loginBtnElement.click();
			System.out.println("Login Button is Clicked");
			Thread.sleep(3000);
		}	
		else System.out.println("Element not found");
		return new LoginPage(driver);
	}
	
	
	public String getPageTitle()
	{
		
		String title = driver.getTitle();
		//System.out.println(title);
		return title;
	}
	
	public boolean verifyBasePageTitle() 
	{
		String expectedPageTitle="realme (India) - Dare to leap";
		System.out.println(getPageTitle());
		//return getPageTitle().contains(expectedPageTitle);
		if(expectedPageTitle.contentEquals(getPageTitle()))
		{
			System.out.println("Page Title is Verified");
			return true;
		}
		else 
		{
			System.out.println("Pge Title is not Verified");
			return false;
		}
	}
	
	
	public boolean scrollBy() throws InterruptedException
	{
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000);
		System.out.println("Scrolled");
		return true;
	}
	
	
	public boolean clickAppTab() throws InterruptedException
	{
		
		clickApp.click();
		Thread.sleep(3000);
		System.out.println("App Tab is Clicked");
		return true;
		
		
	}
	
	
	public boolean nextElement() throws InterruptedException
	{
		String parent_handle = driver.getWindowHandle();
		System.out.println(parent_handle);
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		for(String handle1 : allWindow)
		{
			if(!parent_handle.equals(handle1))
		    {
		        driver.switchTo().window(handle1);
		        System.out.println(handle1);
		        scrollBy();
		       return true;
//		        String text = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]")).getText();
//		        System.out.println(text);
		    }
			
		}
		return false;

	}
	
	
	
	
	
	
}
	
