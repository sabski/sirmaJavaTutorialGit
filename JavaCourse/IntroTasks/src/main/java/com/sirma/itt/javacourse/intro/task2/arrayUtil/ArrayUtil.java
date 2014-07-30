package com.sirma.itt.javacourse.intro.task2.arrayUtil;

import com.sirma.itt.javacourse.Utils;

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
		if (Utils.isNull(arr)) {
			Utils.printConsoleMessage("Array is null !!!");
			return;
		}

		StringBuilder build = new StringBuilder();
		build.append("[");
		for (int i : arr) {
			build.append(i + " ");
		}
		build.append("]");
		Utils.printConsoleMessage(build.toString());
	}

	/**
	 * Sums all the element of a given array of Integers.
	 * 
	 * @param arr
	 *            the array to be summed
	 * @return the summed value of the array
	 */
	public int sum(int[] arr) {
		if (Utils.isNull(arr)) {
			Utils.printConsoleMessage("Array is null !!!");
			return -1;
		}
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
		if (Utils.isNull(arr)) {
			Utils.printConsoleMessage("Array is null !!!");
			return -1;
		}
		int minValue = Integer.MAX_VALUE;

		for (int i : arr) {
			if (minValue > i) {
				minValue = i;
			}
		}
		return minValue;
	}
}
