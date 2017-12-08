package goeurotest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.SearchPage;
import pageobjects.TestBase;

public class PriceSortingTest extends TestBase {
	SearchPage page = new SearchPage(driver);
	Header headerMenu = new Header(driver);

	@Parameters({ "browser", "url" })
	public PriceSortingTest(String browser, String url) {
		super(browser, url);
	}

	@Test
	public void basicScenario() throws InterruptedException {

		page.search("Berlin,", "Prague", true);
	}

}
