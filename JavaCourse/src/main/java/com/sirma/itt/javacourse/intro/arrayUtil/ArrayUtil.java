package com.sirma.itt.javacourse.intro.arrayUtil;

/**
 * Array utility class which contains some basic utility methods.
 * 
 * @author simeon
 */
public class ArrayUtil {

	/**
	 * Prints in the console the elements of a given array.
	 * 
	 * @param arr
	 *            array to be printed in the console
	 */
	public void print(int[] arr) {
		for (int i : arr) {
			System.out.println("Array elment = " + i);
		}
	}

	/**
	 * Sums all the element of a given array of Integers.
	 * 
	 * @param arr
	 *            the array to be summed
	 * @return the summed value of the array
	 */
	public int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	/**
	 * Find the smallest element in a array of Integers.
	 * 
	 * @param arr
	 *            the array to be searched
	 * @return the smallest element of the array
	 */
	public int getMinElement(int[] arr) {
		int minValue = Integer.MAX_VALUE;

		for (int i : arr) {
			if (minValue > i) {
				minValue = i;
			}
		}
		return minValue;
	}
}
