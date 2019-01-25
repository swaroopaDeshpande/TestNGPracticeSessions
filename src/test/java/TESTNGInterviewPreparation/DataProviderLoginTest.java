package TESTNGInterviewPreparation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class DataProviderLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("BeforeTest-->Launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = TestUtil.getDataFromSheet("login");
		return data;
	}

	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) {
		login(username, password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void login(String username, String password) {
		System.out.println("Username is :" + username + "Password is : " + password);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		// WebElement submitBtn =
		// driver.findElement(By.xpath("//input[@value='Login']"));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", submitBtn);
	}
}
