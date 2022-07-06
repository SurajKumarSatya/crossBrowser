package com.pack.tests;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.pack.base.TestBaseSetup;

	import com.pack.pageObjects.BasePage;
	import com.pack.pageObjects.CreateAccountPage;
	import com.pack.pageObjects.LoginPage;

	public class CreateAccountPageTest extends TestBaseSetup 
	{
		WebDriver driver;
		LoginPage signInPage;
		BasePage basePage;
		CreateAccountPage createAccountPage;
			
//			@BeforeClass
//			public void setUp(WebDriver driver) 
//			{
//				this.driver = driver;
//			}
			
			
			@BeforeClass
			public void setUp() {
				driver=getDriver();
			}
			
			@Test
			public void verifyCreateAnAccounPage() throws InterruptedException {
				System.out.println("Create An Account page test...");
				basePage = new BasePage(driver);
				signInPage = basePage.clickLoginInBtn();
				createAccountPage = signInPage.clickonCreateAnAccount();
				//Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
				createAccountPage.verifyPageTitle();
				//Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
				createAccountPage.verifyCreateAccountPageText();
			}
			
			public void verifySignInFunction() {
				
			}

	}

