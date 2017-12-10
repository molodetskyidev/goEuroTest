package goeurotest;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Header;
import pageobjects.SearchPage;
import pageobjects.SearchResultPage;
import pageobjects.TestBase;
import utils.Utils;

public class PriceSortingTest extends TestBase {
	SearchPage searchPage = new SearchPage(driver);
	Header headerMenu = new Header(driver);
	SearchResultPage searchResultPage = new SearchResultPage(driver);

	@Parameters({ "browser", "url" })
	public PriceSortingTest(String browser, String url) {
		super(browser, url);
	}

	@Test
	public void basicScenario() throws InterruptedException {
		String[] expectedCities = new String[] { "Berlin", "Prague" };
		String[] actualCities;
		double[] actualPrices;
		double[] sortedPrices;
		// make search
		searchPage.search("Berlin,", "Prague");
		// wait until search is completed
		// searchResultPage.waitForSearchResult();
		// TODO replace it by some type of wait
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("unstoppable");
		}
		// take cities names on search result page
		actualCities = searchResultPage.getSearchResultCities();
		// check departure city is the same we are searching
		Assert.assertEquals(actualCities[0], expectedCities[0], "Departure city in search result is wrong!");
		// check arrival city is the same we are searching
		Assert.assertEquals(actualCities[1], expectedCities[1], "Arrival city in search result is wrong!");
		// Click on Cheapest sorting option
		searchResultPage.setSorting("Cheapest");
		// TODO replace it by some type of wait
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("unstoppable");
		}
		// collect prices on active tab
		actualPrices = searchResultPage.getPricesFromSearchResult();
		// sort prices and compare sorted prices with price order on the page
		sortedPrices = Utils.sortPrices(actualPrices);
		Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");
		// remember last price on the current page
		double lastPrice = sortedPrices[sortedPrices.length - 1];
		// go to next pages if there is Next button
		while (searchResultPage.isThereMorePages()) {
			searchResultPage.clickNext();
			// TODO replace it by some type of wait
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("unstoppable");
			}

			// collect prices on active tab
			actualPrices = searchResultPage.getPricesFromSearchResult();
			// sort prices and compare sorted prices with price order on the
			// page
			sortedPrices = Utils.sortPrices(actualPrices);
			Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");
			// check if first price on new page is less than last price on
			// previous page
			Assert.assertFalse(lastPrice > sortedPrices[sortedPrices.length - 1], "Price on current page" + lastPrice
					+ " is less than on previous page (" + sortedPrices[sortedPrices.length - 1] + ")");
			// remember last price on the current page
			lastPrice = sortedPrices[sortedPrices.length - 1];

		}
		// go to next Tab
		searchResultPage.goToFlightsTab();
		// TODO replace it by some type of wait
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("unstoppable");
		}
		// collect prices on active tab
		actualPrices = searchResultPage.getPricesFromSearchResult();
		// sort prices and compare sorted prices with price order on the page
		sortedPrices = Utils.sortPrices(actualPrices);
		Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");

		// remember last price on the current page
		lastPrice = sortedPrices[sortedPrices.length - 1];
		// go to next pages if there is Next button
		while (searchResultPage.isThereMorePages()) {
			searchResultPage.clickNext();
			// TODO replace it by some type of wait
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("unstoppable");
			}

			// collect prices on active tab
			actualPrices = searchResultPage.getPricesFromSearchResult();
			// sort prices and compare sorted prices with price order on the
			// page
			sortedPrices = Utils.sortPrices(actualPrices);
			Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");
			// check if first price on new page is less than last price on
			// previous page
			Assert.assertFalse(lastPrice > sortedPrices[sortedPrices.length - 1], "Price on current page" + lastPrice
					+ " is less than on previous page (" + sortedPrices[sortedPrices.length - 1] + ")");
			// remember last price on the current page
			lastPrice = sortedPrices[sortedPrices.length - 1];

		}
		// go to next Tab
		searchResultPage.goToBusesTab();
		// TODO replace it by some type of wait
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("unstoppable");
		}
		// collect prices on active tab
		actualPrices = searchResultPage.getPricesFromSearchResult();
		// sort prices and compare sorted prices with price order on the page
		sortedPrices = Utils.sortPrices(actualPrices);
		Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");

		// remember last price on the current page
		lastPrice = sortedPrices[sortedPrices.length - 1];
		// go to next pages if there is Next button
		while (searchResultPage.isThereMorePages()) {
			searchResultPage.clickNext();
			// TODO replace it by some type of wait
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("unstoppable");
			}

			// collect prices on active tab
			actualPrices = searchResultPage.getPricesFromSearchResult();
			// sort prices and compare sorted prices with price order on the
			// page
			sortedPrices = Utils.sortPrices(actualPrices);
			Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Prices are not sorted!");
			// check if first price on new page is less than last price on
			// previous page
			Assert.assertFalse(lastPrice > sortedPrices[sortedPrices.length - 1], "Price on current page" + lastPrice
					+ " is less than on previous page (" + sortedPrices[sortedPrices.length - 1] + ")");
			// remember last price on the current page
			lastPrice = sortedPrices[sortedPrices.length - 1];

		}

	}
}
