package com.sirma.itt.javacourse.intro.median;

import com.sirma.itt.javacourse.intro.arrayUtil.ArrayUtil;

/**
 * Class for finding the median of an array.
 * 
 * @author simeon
 */
public class FindArrayMedian {

	private ArrayUtil util = new ArrayUtil();

	/**
	 * Finds the median of the given array.
	 * 
	 * @param arr
	 *            the array to be searched
	 * @return the index of the median in the array.
	 */
	public int findMedian(int[] arr) {
		int index = 0;
		int minDifference = Integer.MAX_VALUE;
		int tempDifference;

		int sumOne;
		int sumTwo;
		for (int i = 0; i < arr.length; i++) {
			int[] arr1 = splitArray(arr, 0, i);
			int[] arr2 = splitArray(arr, i, arr.length);
			sumOne = util.sum(arr1);
			sumTwo = util.sum(arr2);

			if (sumOne > sumTwo) {
				tempDifference = sumOne - sumTwo;
			} else {
				tempDifference = sumTwo - sumOne;
			}

			if (minDifference >= tempDifference) {
				minDifference = tempDifference;
				index = i;
			}
		}
		return index + 1;
	}

	/**
	 * Splits the array from begin index to end index.
	 * 
	 * @param arr
	 *            the array to be split.
	 * @param begin
	 *            the first index from the source array to be split
	 * @param end
	 *            the last index of the array to be split
	 * @return a new array that contains the values from the range begin to end.
	 */
	public int[] splitArray(int[] arr, int begin, int end) {

		int lenght = end - begin;
		int[] result = new int[lenght];
		for (int i = 0; i < lenght; i++) {
			result[i] = arr[begin + i];
		}
		if (begin == 0 && end == 0) {
			result = new int[1];
			result[0] = arr[0];
		}
		if (arr.length == begin && arr.length == end) {
			result = new int[1];
			result[0] = arr[begin - 1];
		}

		return result;
	}

	/**
	 * Second method for finding the array median.
	 * 
	 * @param arr
	 *            to be searched for its median
	 * @return the index value of the median element + 1.
	 */
	public int calculateMedian(int[] arr) {
		int index = -1;
		int difference = Integer.MAX_VALUE;
		int length = arr.length / 2;
		System.out.println("Array length is " + arr.length + " and lenght is " + length);

		if (arr.length % 2 == 1) {
			length++;
		}

		int indexA = 0;
		int indexB = 0;
		System.out.println("Lenght is " + length);
		for (int i = 1; i <= length; i++) {
			int[] arr1 = splitArray(arr, 0, i + 1);
			int[] arr2 = splitArray(arr, arr.length - i - 1, arr.length);
			int sumOne = util.sum(arr1);
			int sumTwo = util.sum(arr2);
			int tempIndex = -1;
			indexA = i;
			indexB = arr.length - i - 1;

			int tempDiference;

			if (sumOne > sumTwo) {
				tempDiference = sumOne - sumTwo;
				tempIndex = indexB;
			} else {
				tempDiference = sumTwo - sumOne;
				tempIndex = indexA;
			}

			System.out.println("Temp difference is " + tempDiference + " at index " + i
					+ " sumone is = " + sumOne + " sumtwo is = " + sumTwo);
			if (difference >= tempDiference) {
				System.out.println("New diff");
				index = tempIndex;
				difference = tempDiference;
			}
			System.out.println(indexA + " " + indexB);
		}

		if (arr.length % 2 == 1) {
			return index + 1;
		} else {
			return index;
		}

	}

}
