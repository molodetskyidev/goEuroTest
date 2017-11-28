package pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	// it's a base for all tests, contains webdriver initialisation and opening
	// browser with baseurl based on global.properties
	public static WebDriver driver = null;

	public void setup() {

		Properties properties = new Properties(); // here we store properties
		try {
			// properties are stored in this file
			// TODO should change it to relative path
			FileInputStream fi = new FileInputStream(
					"/Users/alexander/Documents/workspace/goeurotest/src/main/java/pageobjects/global.properties");

			properties.load(fi); // load properties from the file
			if (properties.getProperty("browser").contains("firefox")) {
				// if browser in properties is set to firefox
				// set driver to FirefoxDriver
				// TODO may be it's needed to work with Firefox profile here
				driver = new FirefoxDriver();
				// if browser in properties is set to chrome
			} else if (properties.getProperty("browser").contains("chrome")) {
				// set driver to ChromeDriver
				driver = new ChromeDriver();
				// TODO add other drivers as well
			}
			// get baseurl from properties
			String url = properties.getProperty("url");
			driver.get(url); // open url in selected browser
			driver.manage().window().maximize(); // maximize window
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // wait
																				// 10
																				// seconds
																				// until
																				// page
																				// is
																				// loaded
			// TODO maybe change in to explicityWait with checking visibility of
			// some element
		} catch (FileNotFoundException e) {
			// TODO think how to handle case if properties file not found
			e.printStackTrace();
		} catch (IOException e) {
			// TODO think how to handle case if properties file is not readable
			e.printStackTrace();
		}

	}

	public TestBase() {
		this.setup();
	}

}
