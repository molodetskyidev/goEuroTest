package goeurotest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.TestBase;

public class HomePageTest extends TestBase {
	String pageTitle;
	String currency;
	Header headerMenu = new Header(driver);

	@Parameters({ "browser", "url" })
	public HomePageTest(String browser, String url) {
		super(browser, url);
	}

	@Test
	// This test verifies if searchPage is changed to European Trains searchPage while user
	// clicks Trains link on the top of GoEuro searchPage
	public void switchTrains() {
		headerMenu.goTrains(); // click on Trains link
		// TODO maybe add wait for case of slow connection
		pageTitle = driver.getTitle(); // take title of the opened searchPage
		Assert.assertEquals(pageTitle, "European Trains | GoEuro"); // check
																	// that
																	// title of
																	// the
																	// opened
																	// searchPage is
																	// "European
																	// Trains |
																	// GoEuro"
	}

	@Test
	// This test verifies if searchPage is changed to Buses in Europe searchPage while user
	// clicks Trains link on the top of GoEuro searchPage
	public void switchBuses() {
		headerMenu.goBuses();// click on Buses link
		// TODO maybe add wait for case of slow connection
		pageTitle = driver.getTitle(); // take title of the opened searchPage
		Assert.assertEquals(pageTitle, "Buses in Europe | GoEuro"); // check
																	// that
																	// title of
																	// the
																	// opened
																	// searchPage is
																	// "Buses in
																	// Europe |
																	// GoEuro"
	}

	@Test
	// This test verifies if searchPage is changed to Cheap Flights in Europe searchPage
	// while user clicks Trains link on the top of GoEuro searchPage
	public void switchFlights() {
		headerMenu.goFlights(); // click on Flights link
		pageTitle = driver.getTitle(); // take title of the opened searchPage
		Assert.assertEquals(pageTitle, "Cheap Flights in Europe | GoEuro"); // check
																			// that
																			// title
																			// of
																			// the
																			// opened
																			// searchPage
																			// is
																			// "Cheap
																			// Flights
																			// in
																			// Europe
																			// |
																			// GoEuro"
	}

	@Test
	// this test check that user can change currency on home searchPage
	public void changeCurrency() {
		headerMenu.setCurrency("RUB"); // set currency RUB
		String selectedCurrency = headerMenu.getCurrency(); // check current
															// currency on the
															// searchPage
		// check that current currency = currency we set
		Assert.assertEquals(selectedCurrency, "RUB", "Currency is not set as expected!");
	}

	@Test
	// this test check that user can change language on home searchPage
	public void changeLanguage() {
		headerMenu.setLanguage("DE");
		String selectedLanguage = headerMenu.getLanguage();// check current
															// language on the
															// searchPage
		// check that current language = language we set
		Assert.assertEquals(selectedLanguage, "DE", "Language is not set as expected!");
	}
}
