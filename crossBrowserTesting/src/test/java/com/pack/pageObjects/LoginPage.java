package com.pack.pageObjects;


	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
//	import org.testng.Assert;

	public class LoginPage 
	{

		WebDriver driver;
		
		@FindBy(xpath = "//a[text()='realme']") WebElement headerPageText;
		
		@FindBy(xpath = "//div[text()='Create account']") WebElement CreateAccount;
		
		
		@FindBy(xpath = "//label[text()='Login'])[1]") WebElement LoginButton;

//	private By headerPageText = By.cssSelector(".hidden-small");
//	private By createAccountLink = By.id("link-signup");
//	private By emailTextBox = By.id("Email");
//	private By passwordTextBox = By.id("Passwd");
//	private By loginBtn = By.id("signIn");
//	private By errorMsgTxt = By.id("errormsg_0_Passwd");
		
		public LoginPage(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public String getLoginPageTitle() 
		{
			String pageTitle = driver.getTitle();
			//System.out.println(pageTitle);
			return pageTitle;
		}
		
		public boolean verifyLoginPageTitle() 
		{
			//String expectedTitle = "realme (India) - Dare to leap";
			String expectedTitle = "Sign in";
			String actualTitle = getLoginPageTitle();
			System.out.println("Login Page Title : "+actualTitle);
			//return getLoginPageTitle().contains(expectedTitle);
			if(expectedTitle.contentEquals(actualTitle))
			{
				System.out.println("Login Page Title is Verified");
				return true;
			}
			else
			{
				System.out.println("Login Page Title is Wrong");
				return false;
			}
			
			 
		}
		
		public boolean verifyLoginPageText() 
		{
			//WebElement element = driver.findElement(headerPageText);
			
			String pageText = headerPageText.getText();
			System.out.println("Login Page Text : "+pageText);
			String expectedPageText = "realme";
			//return pageText.contains(expectedPageText);
			if(expectedPageText.contentEquals(pageText))
			{
				System.out.println("Login Page Text is Verified");
				return true;
			}
			else
			{
				System.out.println("Login Page Text is Wrong");
				return false;
			}
		}
		
		public CreateAccountPage clickonCreateAnAccount() throws InterruptedException 
		{
				//WebElement element=driver.findElement(CreateAccount);
				System.out.println("Clicking on Create Account Button");
				if(CreateAccount.isDisplayed()||CreateAccount.isEnabled())
				{
					System.out.println("Create Account Button is Enabled or Displayed");
					CreateAccount.click();
					System.out.println("Create Account Button is Clicked");
					Thread.sleep(2000);
					
				}
				else
				{
					System.out.println("Create Account Button is NOT Enabled");
				}
					//CreateAccount.click();
				return new CreateAccountPage(driver);
		}
			
//			public boolean verifySignIn() {
//				enterUserName("test");
//				enterPassword("pass");
//				clickOnSignIn();
//				return getErrorMessage().contains("incorrect");
//			}
			
//			public void enterUserName(String userName) {
//				WebElement emailTxtBox = driver.findElement(emailTextBox);
//				if(emailTxtBox.isDisplayed())
//					emailTxtBox.sendKeys(userName);
//			}
			
//			public void enterPassword(String password) {
//				WebElement passwordTxtBox = driver.findElement(passwordTextBox);
//				if(passwordTxtBox.isDisplayed())
//					passwordTxtBox.sendKeys(password);
//			}
			
			public void clickOnLogin() {
				//WebElement signInBtn = driver.findElement(loginBtn);
				if(LoginButton.isDisplayed())
					LoginButton.click();
			}
			
//			public String getErrorMessage() {
//				String strErrorMsg = null;
//				WebElement errorMsg = driver.findElement(errorMsgTxt);
//				if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
//					strErrorMsg = errorMsg.getText();
//				return strErrorMsg;
//			}
	}

