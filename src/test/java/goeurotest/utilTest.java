package goeurotest;

import org.testng.annotations.Test;

import utils.Utils;

public class utilTest {
	double[] test = { 1329.0, 31.1, 72.99 };

	@Test
	public void convertTest() {

		String[] str = { "1,329.00", "31.10", "72.99" };
		double[] d = Utils.priceConvertor(str, "EUR");
		for (double dd : d) {
			System.out.println(dd);
		}
	}

	@Test
	public void priceToString() {

		String testStr = Utils.priceToString(test);
		System.out.println(testStr);
	}

	@Test
	public void sortTest() {
		double[] d = { 1329.0, 31.1, 72.99 };
		double[] d2 = Utils.sortPrices(d);
		for (double dd : d2) {
			System.out.println(dd);
		}
	}

}
