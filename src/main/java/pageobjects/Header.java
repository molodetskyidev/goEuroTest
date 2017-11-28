package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
	WebDriver driver;
	// TODO there are 3 elements found by each of link, click still works but
	// should change xpath to more precise
	By trainsLink = By.xpath("//a[@href='/trains/']");
	By flightsLink = By.xpath("//a[@href='/flights/']");
	By busesLink = By.xpath("//a[@href='/buses/']");

	public void goTrains() {
		driver.findElement(trainsLink).click();
	}

	public void goBuses() {
		driver.findElement(busesLink).click();
	}

	public void goFlights() {
		driver.findElement(flightsLink).click();
	}

	public Header(WebDriver driver) {
		this.driver = driver;
	}
}
