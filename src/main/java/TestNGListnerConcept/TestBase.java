package TestNGListnerConcept;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;

	public static void init() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new com.excel.utility.WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.get("https://app.hubspot.com/login");
	}

	public void failedTcScreenshots(String testMethodName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File("C:\\Users\\HP\\workspace\\TestNGPracto\\src\\main\\java\\Screenshots\\" + testMethodName
							+ "_" + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
