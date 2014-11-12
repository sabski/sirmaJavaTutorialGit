package com.sirma.itt.javacourse.intro.task4.arraySorting;

import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class for running the QuickSort class.
 * 
 * @author simeon
 */
public class RunQuickSort {

	/**
	 * Main method for QuickSortImpl.
	 * 
	 * @param args
	 *            for main method.
	 */
	public static void main(String[] args) {

		List<Integer> arr = InputUtils.inputListOfIntegers();

		InputUtils.printConsoleMessage("Array before sorting " + arr);
		InputUtils.printConsoleMessage("Array after sorting " + QuickSortImpl.quickSortArray(arr));
	}

}
