package goeurotest;

import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.SearchPage;
import pageobjects.TestBase;

public class HomePageTest extends TestBase {
	SearchPage page = new SearchPage(driver);
	Header headerMenu = new Header(driver);

	@Test
	public void simpleSearch() throws InterruptedException {

		page.search("Berlin,", "Frankfurt am Main", true);
	}

	// @Test
	// public void trainsSearch() {
	// headerMenu.goTrains();
	// }
	//
	// @Test
	// public void busesSearch() {
	// headerMenu.goBuses();
	// }
	//
	// @Test
	// public void flightsSearch() {
	// headerMenu.goFlights();
	// }
}
