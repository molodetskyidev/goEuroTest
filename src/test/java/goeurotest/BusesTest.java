package goeurotest;

import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.SearchPage;
import pageobjects.TestBase;

public class BusesTest extends TestBase {
	SearchPage page = new SearchPage(driver);
	Header headerMenu = new Header(driver);

	@Test
	public void testPrices() {
		// Open home page
		// go to buses page
		// search for buses from Berlin to Frankfurt

	}
}
