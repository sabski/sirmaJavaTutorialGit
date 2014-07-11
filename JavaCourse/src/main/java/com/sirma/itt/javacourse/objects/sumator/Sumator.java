package com.sirma.itt.javacourse.objects.sumator;

import com.sirma.itt.javacourse.intro.stringCalculator.StringCalculator;

/**
 * Class for summing different object types.
 * 
 * @author simeon
 */
public class Sumator {

	/**
	 * The method sums two int numbers.
	 * 
	 * @param a
	 *            first number to be summed
	 * @param b
	 *            second number to be summed
	 * @return the sum of the two values.
	 */
	public int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Sums two floating point numbers.
	 * 
	 * @param a
	 *            the first number
	 * @param b
	 *            the second number
	 * @return the sum of the two floating point numbers.
	 */
	public float sum(float a, float b) {
		return a + b;
	}

	/**
	 * Calculates the sum of two String numbers.
	 * 
	 * @param a
	 *            the first number to be summed
	 * @param b
	 *            the second number to be summed
	 * @return the sum of the two numbers in String type;
	 */
	public String sum(String a, String b) {
		StringCalculator calculator = new StringCalculator();
		return calculator.sumStrings(a, b);
	}

	/**
	 * Calculates the sum of two java.math.BigInteger number types.
	 * 
	 * @param a
	 *            the first number to be summed
	 * @param b
	 *            the second number to be summed.
	 * @return the sum of the two numbers in java.math.BigInteger type.
	 */
	public java.math.BigInteger sum(java.math.BigInteger a, java.math.BigInteger b) {

		return a.add(b);
	}

	/**
	 * Calculates the sum of two java.math.BigDecimal objects.
	 * 
	 * @param a
	 *            the first Object to be summed.
	 * @param b
	 *            the second object to be summed.
	 * @return the sum of the object in java.math.BigDecimal.
	 */
	public java.math.BigDecimal sum(java.math.BigDecimal a, java.math.BigDecimal b) {

		return a.add(b);
	}
}
