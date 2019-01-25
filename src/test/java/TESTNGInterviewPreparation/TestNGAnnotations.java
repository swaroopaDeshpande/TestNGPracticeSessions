package TESTNGInterviewPreparation;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.out.println("Before Suite-->Setup System properties for chrome");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("BeforeTest-->Launching Chrome browser");
		driver = new ChromeDriver();
	}

	@BeforeClass
	public void login() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
	}

	@BeforeMethod
	public void enterUserDetails() {
		driver.findElement(By.name("username")).sendKeys("MangoD");
		driver.findElement(By.name("password")).sendKeys("MangoDolly");
		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitBtn);
	}

	@Test(priority = 1, groups = "Title")
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO");
	}

	// @Test(priority = 4, invocationCount = 10)
	// public void sum() {
	// System.out.println("Invocation functionality demo");
	// }

	@Test(priority = 2, groups = "Logo", dependsOnMethods = { "titleTest" })
	public void logoTest() {
		System.out.println("CRMPO LOgo Test");
	}

	@Test(priority = 3, groups = "Logo", dependsOnMethods = { "titleTest" })
	public void Test1() {
		System.out.println("CRMPO Test 1");
	}

	// @Test(priority =
	// 5,invocationTimeOut=2,expectedExceptions=NumberFormat.class)
	// public void infiniteLoop() {
	// int i = 1;
	// while (i == 1) {
	// System.out.println(i);
	// }
	// }

	@Test(expectedExceptions = NumberFormatException.class)
	public void test6() {
		String x = "100A";
		Integer.parseInt(x);
	}

	@AfterMethod
	public void logout() {
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	@AfterClass
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void Reports() {
		System.out.println("After suite-->Reports");
	}

}
