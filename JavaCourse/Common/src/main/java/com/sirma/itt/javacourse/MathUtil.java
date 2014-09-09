package com.sirma.itt.javacourse;

/**
 * Math utility method collection.
 * 
 * @author simeon
 */
public class MathUtil {

	/**
	 * Generates a random number within a specified range.
	 * 
	 * @param min
	 *            the lowest value of the range
	 * @param max
	 *            the highest value of the range
	 * @return the generated random value
	 */
	public static int generateRandomNumberWithRange(int min, int max) {

		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * Calculates the greatest common denominator.
	 * 
	 * @param firstNumber
	 *            first number
	 * @param secondNumber
	 *            second number
	 * @return the greatest common denominator
	 */
	public static int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
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
	public static int getLeastCommonDenominator(int firstNumber, int secondNumber) {

		if (firstNumber == 0 || secondNumber == 0) {
			return -1;
		}

		return (firstNumber * secondNumber) / getGreatestCommonDivisor(firstNumber, secondNumber);
	}

	/**
	 * Checks if the given value is within range.
	 * 
	 * @param minValue
	 *            the minimum value that the number can be.
	 * @param maxValue
	 *            the maximum value the number can be.
	 * @param value
	 *            the number to be checked if it is specific range.
	 * @return
	 */
	public static boolean checkInputRange(int minValue, int maxValue, int value) {

		if (minValue > value || value > maxValue) {
			return false;
		} else {
			return true;
		}
	}
}
