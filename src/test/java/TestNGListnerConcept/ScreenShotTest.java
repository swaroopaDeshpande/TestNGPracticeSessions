package TestNGListnerConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Analyzer.CustomListner;

@Listeners(CustomListner.class)
public class ScreenShotTest extends TestBase {

	@BeforeMethod
	public void setup() {
		System.out.println("Setup");
		init();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("closing browser");
		driver.close();
	}

	@Test
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("swarup.deshpande24@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		driver.findElement(By.id("loginBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Reports dashboard"));
		String title = driver.getTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, "Reports dashboard");
	}
	
	

}
