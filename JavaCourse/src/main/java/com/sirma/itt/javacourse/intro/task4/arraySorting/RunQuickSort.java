package com.sirma.itt.javacourse.intro.task4.arraySorting;

import java.util.ArrayList;

import com.sirma.itt.javacourse.Utils;

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
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr = Utils.inputArrayListOfIntegers();

		System.out.println("Array before sorting " + arr);
		System.out.println("Array after sorting " + QuickSortImpl.quickSortArray(arr));
	}

}
