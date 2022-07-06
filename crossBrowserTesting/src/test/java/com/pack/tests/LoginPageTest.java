package com.pack.tests;



	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.pack.base.TestBaseSetup;

	import com.pack.pageObjects.BasePage;
	import com.pack.pageObjects.LoginPage;

	public class LoginPageTest extends TestBaseSetup
	{
		WebDriver driver;
		LoginPage loginPage;
		BasePage basePage;
		
//		@BeforeClass
//		public void setUp(WebDriver driver) 
//		{
//			this.driver = driver;
//		}
			
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		
		@Test
		public void verifySignInFunction() throws InterruptedException 
		{
			System.out.println("Sign In functionality details...");
			basePage = new BasePage(driver);
			loginPage = basePage.clickLoginInBtn();
			//Assert.assertTrue(loginPage.verifyLoginPageTitle(), "Sign In page title doesn't match");
			loginPage.verifyLoginPageTitle();
			//Assert.assertTrue(loginPage.verifyLoginPageText(), "Page text not matching");
			loginPage.verifyLoginPageText();
			//Assert.assertTrue(loginPage.verifyLogin(), "Unable to sign in");

		}

	}

