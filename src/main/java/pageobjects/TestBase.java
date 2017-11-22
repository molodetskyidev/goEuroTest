package pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver = null;

	public void setup() {
		Properties properties = new Properties();
		try {
			FileInputStream fi = new FileInputStream(
					"/Users/alexander/Documents/workspace/goeurotest/src/main/java/pageobjects/global.properties");
			properties.load(fi);
			if (properties.getProperty("browser").contains("firefox")) {
				driver = new FirefoxDriver();

			} else if (properties.getProperty("browser").contains("chrome")) {
				driver = new ChromeDriver();
			}
			String url = properties.getProperty("url");
			driver.get(url);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TestBase() {
		this.setup();
	}

}
