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
}
