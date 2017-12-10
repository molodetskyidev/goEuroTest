package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class SearchResultPage {

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	// Departure city on Search result page
	By depatureCitySearchResult = By.xpath("//input[@id='departureCity']/following-sibling::*//span[@class='sb-city']");
	// arrival city on Search result page
	By arrivalCitySearchResult = By.xpath("//input[@id='arrivalCity']/following-sibling::*//span[@class='sb-city']");
	// Cheapest Sorting option
	By priceSorting = By.xpath("//parent::span[@data-key='dw.sorting.price']");
	// active Tab on search result page
	By activeTab = By.xpath("//a[@class='ResultTabs__activeTab___3KckU ResultTabs__baseTab___9DJWu']");
	// non-active Tab on search result page
	By nonActiveTab = By.xpath("//a[@class='ResultTabs__tab___2RnsZ ResultTabs__baseTab___9DJWu']");
	// main prices from activeTab
	By mainPrice = By.xpath("//span[@data-test='price']//span[@data-test='JourneyDetailsPriceMain']");
	// rest of a price after dot (cents, etc.)
	By restPrice = By
			.xpath("//span[@data-test='price']//span[@data-test='JourneyDetailsPriceMain']//following-sibling::span");
	By selectButtons = By.xpath("//a[@data-test='SelectButton']");
	// Next button
	By nextButton = By.xpath("//span[@data-key='dw.paging.next']");
	// tab elements
	By tabs = By.xpath("//a[@data-test='ResutlTab']");
	// Alternative dates separator
	By alternativeDates = By.xpath("//div[@class='Results__alternativeResultsDivider___CLC0m']");
	By alternativeDatesMainPrices = By.xpath(
			"//div[@class='Results__alternativeResultsDivider___CLC0m']//following::span[@data-test='price']//span[@data-test='JourneyDetailsPriceMain']");
	By alternativeDatesRestPrices = By.xpath(
			"//div[@class='Results__alternativeResultsDivider___CLC0m']//following::span[@data-test='price']//span[@data-test='JourneyDetailsPriceMain']//following-sibling::span");

	public String[] getSearchResultCities() {
		String depCity = driver.findElement(depatureCitySearchResult).getText();
		String arrCity = driver.findElement(arrivalCitySearchResult).getText();
		String[] searchResultCities = new String[] { depCity, arrCity };
		return searchResultCities;
	}

	public void waitForSearchResult() throws InterruptedException {
		// List<WebElement> selectButton;
		// WebDriverWait wait = new WebDriverWait(driver, 100);
		//
		// selectButton = driver.findElements(selectButtons);
		// int i = selectButton.size();
		// System.out.println("select button" + (i - 1) + " " +
		// selectButton.get(i - 1).isEnabled());
		// System.out.println("waiting for " + i + " select buttons");
		// wait.until(ExpectedConditions.elementToBeClickable(selectButton.get(i
		// - 1)));

	}

	public void setSorting(String sorting) {
		switch (sorting) {
		case "Cheapest":
			driver.findElement(priceSorting).click();
			break;
		case "Recommended":
			// TODO implement this sorting
			break;
		case "Fastest":
			// TODO implement this sorting
			break;
		case "Departure Time":
			// TODO implement this sorting
			break;
		case "Arrival Time":
			// TODO implement this sorting
			break;
		default:
			break;
		}
	}

	public double[] getPricesFromSearchResult() {
		int sizeAD = 0;
		List<WebElement> mainPrices = driver.findElements(mainPrice);
		List<WebElement> restPrices = driver.findElements(restPrice);
		// if there is alternative dates
		if (AnyPage.isElementExist(driver, alternativeDates)) {
			List<WebElement> mainPricesAD = driver.findElements(alternativeDatesMainPrices);
			List<WebElement> restPricesAD = driver.findElements(alternativeDatesRestPrices);
			sizeAD = mainPricesAD.size();
		}

		String[] pricesStr = new String[mainPrices.size() - sizeAD];
		for (int i = 0; i < mainPrices.size() - sizeAD; i++) {
			pricesStr[i] = mainPrices.get(i).getText() + restPrices.get(i).getText();
		}
		double[] pricesDouble = Utils.priceConvertor(pricesStr, "EUR");
		return pricesDouble;
	}

	public Boolean isThereMorePages() {
		return AnyPage.isElementExist(driver, nextButton);
	}

	public void goToTab(String tabName) {
		switch (tabName) {
		case "trains":
			driver.findElements(tabs).get(0).click();
			break;
		case "flights":
			driver.findElements(tabs).get(1).click();
			break;
		case "buses":
			driver.findElements(tabs).get(2).click();
			break;
		}

	}

	public void goToTrainsTab() {
		driver.findElements(tabs).get(0).click();
	}

	public void goToFlightsTab() {
		driver.findElements(tabs).get(1).click();
	}

	public void goToBusesTab() {
		driver.findElements(tabs).get(2).click();
	}

	public void clickNext() {
		driver.findElement(nextButton).click();
	}

	public boolean isAlternativeDates() {

		return AnyPage.isElementExist(driver, alternativeDates);

	}

}
