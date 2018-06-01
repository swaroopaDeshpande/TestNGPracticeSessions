package TestNGData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class RegistrationTest {
	// https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo&usage=29438ru=
	WebDriver driver;

	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo&usage=29438ru=");
	}

	
	// this method return 2D object array this is to call logic to fetch data
	// from xl(getDataFromSheet())

	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]  =TestUtil.getDataFromSheet("RegTestData");
		return data;
	}
	@Test(dataProvider = "getLoginData")
	public void registrationTest(String firstname, String lastname, String address1, String address2, String city,
			String state, String zipcode, String emailaddress) {
		WebElement Fname = driver.findElement(By.xpath("//input[@id='firstname' and @type='text']"));
		Fname.clear();
		Fname.sendKeys(firstname);
		WebElement Lname = driver.findElement(By.xpath("//input[@name='lastname' and @type='text']"));
		Lname.clear();
		Lname.sendKeys(lastname);
		WebElement Add = driver.findElement(By.xpath("//input[@name='address1' and @type='text']"));
		Add.clear();
		Add.sendKeys(address1);
		WebElement Add1 = driver.findElement(By.xpath("//input[@name='address2' and @type='text']"));
		Add1.clear();
		Add1.sendKeys(address2);
		WebElement ct=driver.findElement(By.xpath("//input[@name='city' and @type='text']"));
		ct.clear();
		ct.sendKeys(city);
		Select select = new Select(driver.findElement(By.id("state")));
		select.selectByVisibleText(state);
		WebElement zpcd=driver.findElement(By.xpath("//input[@name='zip' and @type='text']"));
		zpcd.clear();
		zpcd.sendKeys(zipcode);
		WebElement email= driver.findElement(By.xpath("//input[@name='email' and @type='text']"));
		email.clear();
		email.sendKeys(emailaddress);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
