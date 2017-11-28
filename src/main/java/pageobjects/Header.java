package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
	WebDriver driver;
	By trainsLink = By.xpath("//li[@class='mode-title']/a[@href='/trains/']"); // Trains
																				// link
	By flightsLink = By.xpath("//li[@class='mode-title']/a[@href='/flights/']"); // Flights
																					// link
	By busesLink = By.xpath("//li[@class='mode-title']/a[@href='/buses/']"); // Buses
																				// link
	By currency = By.xpath("//div[@id='currencySwitcher']//nav/p/span"); // currency
																			// switcher
	By currencyDropDown = By.xpath("//li[@data-id='EUR']"); //

	// click on Trains link
	public void goTrains() {
		driver.findElement(trainsLink).click();
	}

	// click on Buses link
	public void goBuses() {
		driver.findElement(busesLink).click();
	}

	// click on Flights link
	public void goFlights() {
		driver.findElement(flightsLink).click();
	}

	// change currency
	public void setCurrency(String currencyValue) {
		// click on currency sign
		driver.findElement(currency).click();
		// in opened dropdown menu select corresponed currency
		driver.findElement(By.xpath("//li[@data-id='" + currencyValue + "']")).click();

	}

	public String getCurrency() {
		String currencySelected, currencySelectedSign;
		// get selected currency sign from the header
		currencySelectedSign = driver.findElement(currency).getText();
		// select currency according the sign
		switch (currencySelectedSign) {
		case "$":
			currencySelected = "USD";
			break;
		case "€":
			currencySelected = "EUR";
			break;
		case "₽":
			currencySelected = "RUB";
			break;
		case "£":
			currencySelected = "GBP";
			break;
		case "zł":
			currencySelected = "PLN";
			break;
		case "SEK":
			currencySelected = "SEK";
			break;
		case "Kč":
			currencySelected = "CZK";
			break;
		case "CHF":
			currencySelected = "CHF";
			break;
		case "¥":
			currencySelected = "CNY";
			break;
		default:
			currencySelected = "NONE";
			break;
		}
		return currencySelected; // return currency
	}

	public Header(WebDriver driver) {
		this.driver = driver;
	}
}
