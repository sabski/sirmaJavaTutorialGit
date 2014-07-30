package com.sirma.itt.javacourse.intro.task1.mathUtil;


/**
 * Math Utility class that provides some mathematical functionality.
 * 
 * @author simeon
 */

public class MathUtil {

	/**
	 * Calculates the greatest common denominator.
	 * 
	 * @param firstNumber
	 *            first number
	 * @param secondNumber
	 *            second number
	 * @return the greatest common denominator
	 */
	public int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
		int temp;
		if (firstNumber == 0 || secondNumber == 0) {
			return -1;
		}
		if (firstNumber == secondNumber) {
			return firstNumber;
		} else if (firstNumber > secondNumber) {
			temp = firstNumber - secondNumber;
			return getGreatestCommonDivisor(temp, secondNumber);
		} else {
			temp = secondNumber - firstNumber;
			return getGreatestCommonDivisor(firstNumber, temp);
		}

	}

	/**
	 * Calculates the least common denominator of two numbers.
	 * 
	 * @param firstNumber
	 *            first number
	 * @param secondNumber
	 *            second number
	 * @return the least common denominator
	 */
	public int getLeastCommonDenominator(int firstNumber, int secondNumber) {

		if (firstNumber == 0 || secondNumber == 0) {
			return -1;
		}

		return (firstNumber * secondNumber) / getGreatestCommonDivisor(firstNumber, secondNumber);
	}
}
