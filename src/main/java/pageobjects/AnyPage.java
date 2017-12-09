package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnyPage {
	WebDriver driver;

	public static Boolean isElementExist(WebDriver driver, By locator) {
		int numberOfNextButton = driver.findElements(locator).size();
		if (numberOfNextButton > 0) {
			return true;
		} else {
			return false;
		}
	}
}
