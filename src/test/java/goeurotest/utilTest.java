package goeurotest;

import org.testng.annotations.Test;

import utils.Utils;

public class utilTest {
	@Test
	public void convertTest() {
		String[] str = { "29.00", "31.10", "72.99" };
		double[] d = Utils.priceConvertor(str);
		for (double dd : d) {
			System.out.println(dd);
		}
	}

	@Test
	public void sortTest() {
		double[] d = { 31.2, 31.1, 72.99 };
		double[] d2 = Utils.sortPrices(d);
		for (double dd : d2) {
			System.out.println(dd);
		}
	}

}
