package com.sirma.itt.javacourse.intro.task4.arraySorting;

import java.util.ArrayList;

import com.sirma.itt.javacourse.InputUtil;

/**
 * Class for running the QuickSort class.
 * 
 * @author simeon
 */
public class RunQuickSort {

	/**
	 * @param args
	 *            for main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		QuickSortImpl impl = new QuickSortImpl();
		int numbersCount = 0;
		System.out.println("Plese input numbers for the array");
		numbersCount = InputUtil.readLineNumber();
		for (int i = 0; i < numbersCount; i++) {
			arr.add(InputUtil.readLineNumber());
		}
		System.out.println("Array before sorting " + arr.toString());
		System.out.println("Array after sorting " + impl.quickSortArray(arr).toString());
	}

}
