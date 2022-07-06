package com.pack.pageObjects;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class CreateAccountPage 
	{

		WebDriver driver;
//		By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");
		@FindBy(xpath = "//h1[text()='Create account']") WebElement headerPageText;
		
		
		public CreateAccountPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public String getPageTitle() {
			String title = driver.getTitle();
			//System.out.println(title);
			return title;
		}
		
		public boolean verifyPageTitle() {
			String pageTitle = "Create account";
			if(getPageTitle().contentEquals(pageTitle))
			{
				System.out.println("Page Title is Verified");
				return true;
			}
			else
			{
				System.out.println("Page Title is NOT Verified");
				return false;
			}
			//return getPageTitle().contains(pageTitle);
		}
		public boolean verifyCreateAccountPageText() {
			//WebElement element = driver.findElement(headerPageTxt);
			String pageText ="Create account";
			if(headerPageText.getText().contentEquals(pageText))
			{
				System.out.println("Account Page Text Verified");
				return true;
			}
			else
			{
				System.out.println("Account Page Text is NOT Verified");
				return false;
			}
			//return element.getText().contains(pageText);
		}
		
		public void createAccount() {
			//need to write steps for creating an account
		}
	}

