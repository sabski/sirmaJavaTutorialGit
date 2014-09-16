package com.sirma.itt.javacourse.intro.task4.arraySorting;

import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

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

		List<Integer> arr = IOUtils.inputListOfIntegers();

		IOUtils.printConsoleMessage("Array before sorting " + arr);
		IOUtils.printConsoleMessage("Array after sorting " + QuickSortImpl.quickSortArray(arr));
	}

}
