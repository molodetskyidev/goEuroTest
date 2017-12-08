package goeurotest;

import org.testng.annotations.Parameters;

import pageobjects.Header;
import pageobjects.SearchPage;
import pageobjects.TestBase;

public class BusesTest extends TestBase {
	@Parameters({ "browser", "url" })
	public BusesTest(String browser, String url) {
		super(browser, url);
	}

	SearchPage page = new SearchPage(driver);
	Header headerMenu = new Header(driver);

}
