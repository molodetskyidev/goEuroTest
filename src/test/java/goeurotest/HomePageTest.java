package goeurotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.TestBase;

public class HomePageTest extends TestBase {
	String pageTitle;
	String currency;
	Header headerMenu = new Header(driver);

	@Test
	// This test verifies if page is changed to European Trains page while user
	// clicks Trains link on the top of GoEuro page
	public void switchTrains() {
		headerMenu.goTrains(); // click on Trains link
		// TODO maybe add wait for case of slow connection
		pageTitle = driver.getTitle(); // take title of the opened page
		Assert.assertEquals(pageTitle, "European Trains | GoEuro"); // check
																	// that
																	// title of
																	// the
																	// opened
																	// page is
																	// "European
																	// Trains |
																	// GoEuro"
	}

	@Test
	// This test verifies if page is changed to Buses in Europe page while user
	// clicks Trains link on the top of GoEuro page
	public void switchBuses() {
		headerMenu.goBuses();// click on Buses link
		// TODO maybe add wait for case of slow connection
		pageTitle = driver.getTitle(); // take title of the opened page
		Assert.assertEquals(pageTitle, "Buses in Europe | GoEuro"); // check
																	// that
																	// title of
																	// the
																	// opened
																	// page is
																	// "Buses in
																	// Europe |
																	// GoEuro"
	}

	@Test
	// This test verifies if page is changed to Cheap Flights in Europe page
	// while user clicks Trains link on the top of GoEuro page
	public void switchFlights() {
		headerMenu.goFlights(); // click on Flights link
		pageTitle = driver.getTitle(); // take title of the opened page
		Assert.assertEquals(pageTitle, "Cheap Flights in Europe | GoEuro"); // check
																			// that
																			// title
																			// of
																			// the
																			// opened
																			// page
																			// is
																			// "Cheap
																			// Flights
																			// in
																			// Europe
																			// |
																			// GoEuro"
	}

	@Test
	// this test check that user can change currency on home page
	public void changeCurrency() {
		headerMenu.setCurrency("RUB");
		String selectedCurrency = headerMenu.getCurrency();
		Assert.assertEquals(selectedCurrency, "RUB", "Currency is not set as expected!");
	}
}
