package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
	WebDriver driver;
	// TODO it appeared that href for other languages are another, so this one
	// is working only for English should think how to change it to be common
	By trainsLink = By.xpath("//li[@class='mode-title']/a[@href='/trains/']"); // Trains
																				// link
	By flightsLink = By.xpath("//li[@class='mode-title']/a[@href='/flights/']"); // Flights
																					// link
	By busesLink = By.xpath("//li[@class='mode-title']/a[@href='/buses/']"); // Buses
																				// link
	By currency = By.xpath("//div[@id='currencySwitcher']//nav/p/span"); // currency
																			// switcher
	By language = By.xpath("//p[@id='dropMenuToggle']/span[contains(@class,'flag')]"); // language
																						// switcher

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

	// change language - possible values: RU, UK, ES, IT, PL, CZ, PT, DE, FR,
	// NL, CN, SE
	public void setLanguage(String languageValue) {
		// click on the flag
		driver.findElement(language).click();
		// in opened dropdown menu select corresponded language
		driver.findElement(By.xpath("//div[@id='langSwitcher']//a[@data-st='" + languageValue + "']")).click();
	}

	public String getLanguage() {
		String languageSelected, languageSelectedFlag;
		languageSelectedFlag = driver.findElement(language).getAttribute("class");
		int i = languageSelectedFlag.length();
		languageSelected = languageSelectedFlag.substring(i - 2);
		System.out.println(languageSelected);
		return languageSelected;
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
