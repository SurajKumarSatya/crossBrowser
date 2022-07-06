package pageObjects;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBrowser 
{
	
	WebDriver driver ;
	
	
	@BeforeTest
	@Parameters("browser")
	public void selectBrowser(String browserName)
	{
	
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 driver = WebDriverManager.chromedriver().create();
					
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver = WebDriverManager.firefoxdriver().create();
			

		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver = WebDriverManager.edgedriver().create();
			

		}
		

	}
	
	
	@Test
	public void url() throws InterruptedException
	{
		driver.get("https://www.gmail.com");
		
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void closeSetUp()
	{
		driver.close();
	}
}
