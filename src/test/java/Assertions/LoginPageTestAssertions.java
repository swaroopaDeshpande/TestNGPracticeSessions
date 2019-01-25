package Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTestAssertions {

	WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@Test
	public void LoginPagetest() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		boolean flag = driver.findElement(By.xpath("//img[@alt='free crm logo']")).isDisplayed();
		Assert.assertTrue(flag);

	}

}
