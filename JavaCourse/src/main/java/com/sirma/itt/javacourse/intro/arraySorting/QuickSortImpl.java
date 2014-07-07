package com.sirma.itt.javacourse.intro.arraySorting;

import java.util.ArrayList;

/**
 * Class that implements the Quick Sort algorithm for arrays.
 * @author simeon
 */
public class QuickSortImpl {

	/**
	 * Sorts arrays using the quick sort method.
	 * 
	 * @param arrayToBeSorted
	 *            the array of integers to be sorted
	 * @return the sorted array
	 */
	public ArrayList<Integer> quickSortArray(ArrayList<Integer> arrayToBeSorted) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		if (arrayToBeSorted.size() <= 1) {
			return arrayToBeSorted;
		}
		int pivot = arrayToBeSorted.get(0);

		for (int i = 1; i < arrayToBeSorted.size(); i++) {
			if (arrayToBeSorted.get(i) > pivot) {
				right.add(arrayToBeSorted.get(i));
			} else {
				left.add(arrayToBeSorted.get(i));
			}
		}
		sortedArray.addAll(quickSortArray(left));
		sortedArray.add(pivot);
		sortedArray.addAll(quickSortArray(right));
		return sortedArray;
	}

}
