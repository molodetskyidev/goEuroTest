package utils;

import java.util.Arrays;

public class Utils {
	public static double[] priceConvertor(String[] pricesStr, String currency) {
		double[] pricesDouble = new double[pricesStr.length];
		switch (currency) {
		case "EUR":
			for (int i = 0; i < pricesStr.length; i++) {
				pricesStr[i] = pricesStr[i].replace(",", "");
			}
			break;
		default:
			for (int i = 0; i < pricesStr.length; i++) {
				pricesStr[i] = pricesStr[i].replace(",", "");
			}
			break;
		}
		for (int i = 0; i < pricesStr.length; i++) {
			pricesDouble[i] = Double.parseDouble(pricesStr[i]);
		}
		return pricesDouble;

	}

	public static double[] sortPrices(double[] prices) {
		Arrays.sort(prices);
		return prices;

	}

	public static String priceToString(double[] prices) {
		StringBuffer priceStr = new StringBuffer();
		for (double price : prices) {
			priceStr.append(Double.toString(price) + ";");
		}

		return priceStr.toString();

	}

}
