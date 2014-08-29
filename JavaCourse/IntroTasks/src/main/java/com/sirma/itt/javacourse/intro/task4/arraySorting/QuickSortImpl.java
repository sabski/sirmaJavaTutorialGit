package com.sirma.itt.javacourse.intro.task4.arraySorting;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that implements the Quick Sort algorithm for arrays.
 * 
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
	public static List<Integer> quickSortArray(List<Integer> arrayToBeSorted) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		List<Integer> sortedArray = new ArrayList<Integer>();
		if (IOUtils.isNull(arrayToBeSorted)) {
			sortedArray.add(-1);
			return sortedArray;
		}

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
