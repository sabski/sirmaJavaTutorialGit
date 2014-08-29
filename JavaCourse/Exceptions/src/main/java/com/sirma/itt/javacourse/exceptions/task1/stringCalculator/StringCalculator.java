package com.sirma.itt.javacourse.exceptions.task1.stringCalculator;


/**
 * Class for calculating big numbers using Strings.
 * 
 * @author simeon
 */
public class StringCalculator {

	/**
	 * Sums two String who contain only number characters.
	 * 
	 * @param firstNumber
	 *            the first String
	 * @param secondNumber
	 *            the second String
	 * @return the String Sum of the given Strings
	 */
	public String sumStrings(String firstNumber, String secondNumber) throws NumberFormatException,
			NullPointerException{

		StringBuilder result = new StringBuilder();
		int lenght;
		boolean isOverTen = false;
/*
		if (IOUtils.isNull(firstNumber) || IOUtils.isNull(secondNumber)) {
			return result.toString();
		}
*/
		String inverseFirstNumber = new StringBuilder(firstNumber).reverse().toString();
		String inverseSecondNumber = new StringBuilder(secondNumber).reverse().toString();

		if (firstNumber.length() > secondNumber.length()) {
			lenght = firstNumber.length();
		} else {
			lenght = secondNumber.length();
		}

		for (int i = 0; i < lenght; i++) {
			int a = 0;
			int b = 0;
			int c = 0;
			if (i < inverseFirstNumber.length()) {
				a = Integer.parseInt("" + inverseFirstNumber.charAt(i));
			}

			if (i < inverseSecondNumber.length()) {
				b = Character.getNumericValue(inverseSecondNumber.charAt(i));
			}

			c = a + b;
			if (isOverTen) {
				c++;
			}

			if (c >= 10) {
				isOverTen = true;
				result.append((c - 10));
			} else {
				result.append(c);
				isOverTen = false;
			}
		}
		if (isOverTen) {
			result.append(1);
		}
		return result.reverse().toString();
	}

}
