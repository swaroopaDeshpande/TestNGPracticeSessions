package TestNGFeatures;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DependsOnMethodFeature {
	
WebDriver driver;
	
	@BeforeTest
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.freecrm.com/index.html");		 
	}

	
	@Test(groups={"LoginPage"},priority=2)
	public void loginTest()
	{
		System.out.println("This is my login test");
		Assert.assertTrue(false,"This is dummy error");
	}
	
	@Test(groups={"submitBtnTest"},priority=3,dependsOnMethods="loginTest")
	public void submitBtnTest()
	{
		System.out.println("This is my submitBtnTest ");
	}
	
	@Test(groups={"LinkTest"},priority=4,dependsOnMethods="loginTest")
	public void LinkTest()
	{
		System.out.println("This is my LinkTest");
	}
	
	@Test(groups={"FeaturesLinkTest"},priority=5,dependsOnMethods="loginTest")
	public void FeaturesLinkTest()
	{
		System.out.println("This is my FeaturesLinkTest ");
	}
	
	@Test(groups={"HomePageTest"},priority=6)
	public void HomePageTest()
	{
		System.out.println("This is my HomePageTest");
	}
	
	@Test(groups={"LogoTest"},priority=1)
	public void LogoTest()
	{
		System.out.println("This is my LogoTest");
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	

}
