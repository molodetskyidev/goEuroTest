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
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "htmlunit":
			driver = new HtmlUnitDriver();
			break;
		default:
			driver = new HtmlUnitDriver();
			break;
		}
		driver.get(baseUrl); // open url in selected browser
		driver.manage().window().maximize(); // maximize window
		// wait 10 seconds until searchPage is loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
