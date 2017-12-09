package utils;

import java.util.Arrays;

public class Utils {
	public static double[] priceConvertor(String[] pricesStr) {
		double[] pricesDouble = new double[pricesStr.length];
		for (int i = 0; i < pricesStr.length; i++) {
			pricesDouble[i] = Double.parseDouble(pricesStr[i]);
		}
		return pricesDouble;

	}

	public static double[] sortPrices(double[] unsortedPrices) {
		double[] sortedPrices = Arrays.copyOf(unsortedPrices, unsortedPrices.length);
		int i = 0;
		while (i < sortedPrices.length) {
			if (i == 0 || sortedPrices[i - 1] <= sortedPrices[i])
				i++;
			else {
				Double temp = sortedPrices[i];
				sortedPrices[i] = sortedPrices[i - 1];
				sortedPrices[i - 1] = temp;
				i--;
			}
		}
		return sortedPrices;

	}

}
