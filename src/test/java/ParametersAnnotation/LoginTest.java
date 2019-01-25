package ParametersAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void launchURL(String browser)
	{
		System.out.println("Running broswer is :"+browser);
		
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if (browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		} else if (browser.equals("ie"))
			
		{
			driver=new InternetExplorerDriver();
		} else if (browser.equals("safari"))
		{
			driver=new SafariDriver();
			
		}
		
		driver.get("https://www.freecrm.com/index.html");
		
	}
	@Parameters({"username","password"})
	@Test(priority=2)
	public void loginTest(String username,String password) 
	{
		System.out.println("username:"+username+"and password"+password);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}

}
