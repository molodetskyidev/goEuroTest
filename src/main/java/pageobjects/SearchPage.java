package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;
	By depatureCityTextField = By.id("departureCity");
	By arrivalCityTextField = By.id("arrivalCity");
	By submitButton = By.xpath("//form[@id='$desktopSearchform']//button");
	By oneWay = By.xpath("//div[@id='tripType']/div[1]");
	By roundTrip = By.xpath("//div[@id='tripType']/div[2]");

	public void search(String depature, String arrival) throws InterruptedException {
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

	public void search(String depature, String arrival, String depatureDate, int numberOfPersons, String RailCard,
			boolean airbnbOption) throws InterruptedException {
		// click on oneWay link
		driver.findElement(oneWay).click();
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

		// TODO set depatureDate
		// TODO set arrivalDate
		// TODO set numberOfPersons
		// TODO set German rail card value
		// TODO check/uncheck airbnbOption

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement submit = driver.findElement(submitButton);
		// wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.submit();

	}

	public void search(String depature, String arrival, String depatureDate, int numberOfPersons, String RailCard,
			boolean airbnbOption, String arrivalDate) throws InterruptedException {
		// click on roundTrip link
		driver.findElement(roundTrip).click();
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
}
