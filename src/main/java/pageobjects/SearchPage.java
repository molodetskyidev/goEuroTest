package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;
	By depatureCityTextField = By.id("departureCity");
	By arrivalCityTextField = By.id("arrivalCity");
	By departureCityDropDown = By.xpath("");
	By submitButton = By.xpath("//form[@id='$desktopSearchform']//button");
	By oneWay = By.xpath("//div[@id='tripType']/div[1]");
	By roundTrip = By.xpath("//div[@id='tripType']/div[2]");

	public void search(String depature, String arrival, boolean oneWayValue) throws InterruptedException {
		// if it's oneWay trip
		if (oneWayValue) {
			// click on oneWay link
			driver.findElement(oneWay).click();
		} else {
			// else click on roundTrip
			driver.findElement(roundTrip).click();
		}
		// enter departure city
		driver.findElement(depatureCityTextField).sendKeys(depature);
		// in autocomplete select city which corresponds to your departure city
		driver.findElement(By.xpath("//form[@id='$desktopSearchform']//span[text()='" + depature
				+ "']//ancestor::li[@class='sb-suggestion ']")).click();
		// enter arrival city
		driver.findElement(arrivalCityTextField).sendKeys(arrival);
		// in autocomplete select city which corresponds to your arrival city
		driver.findElement(By.xpath("//form[@id='$desktopSearchform']//span[text()='" + arrival
				+ "']//ancestor::li[@class='sb-suggestion ']")).click();

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement submit = driver.findElement(submitButton);
		// wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.submit();

	}

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	private void clickDropDownValue(String partialText) {
		List<WebElement> results;
		WebElement dropdownFrom = driver
				.findElement(By.xpath("//form[@id='$desktopSearchform']//ul[@class='sb-list']"));
		results = dropdownFrom.findElements(By.xpath("//ul[@class='sb-list']//span[@class='sb-city']"));
		for (WebElement result : results) {
			if (result.getText().equals(partialText)) {
				result.click();
				break;
			}
		}

	}
}
