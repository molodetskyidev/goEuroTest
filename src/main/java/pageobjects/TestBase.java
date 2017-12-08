package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestBase {
	public static WebDriver driver = null;

	public TestBase(String driverType, String baseUrl) {
		// it's a base for all tests, contains webdriver initialisation and
		// opening
		// browser with baseurl based on global.properties

		switch (driverType) {
		case "firefox":
			driver = new FirefoxDriver();
		case "chrome":
			driver = new ChromeDriver();
		case "htmlunit":
			driver = new HtmlUnitDriver();
		default:
			driver = new HtmlUnitDriver();
		}

		driver.get(baseUrl); // open url in selected browser
		driver.manage().window().maximize(); // maximize window
		// wait 10 seconds until page is loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
