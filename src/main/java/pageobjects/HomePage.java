package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By depatureCity = By.id("departureCity");
	By arrivalCity = By.id("arrivalCity");
	// By submitButton = By.className("sb-col sb-span-3-t sb-span-3-d
	// sb-searchBtn sb-inner-shadow");
	By submitButton = By.xpath("//*[@id=\"$desktopSearchform\"]/div/div[3]/button");

	public void Search(String depature, String arrival) {
		driver.findElement(depatureCity).sendKeys(depature);
		// driver.findElement(arrivalCity).sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(arrivalCity).sendKeys(arrival);
		// driver.findElement(arrivalCity).sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(submitButton).click();

	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
}
