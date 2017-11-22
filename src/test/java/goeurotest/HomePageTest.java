package goeurotest;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.TestBase;

public class HomePageTest extends TestBase {

	@Test
	public void simpleSearch() {
		HomePage page = new HomePage(driver);
		page.Search("Berlin, Germany", "Frankfurt am Main Germany");
	}
}
