package com.sirma.itt.javacourse.intro.arraySorting;

import java.util.ArrayList;

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
		arr.add(5);
		arr.add(3);
		arr.add(9);
		arr.add(2);
		arr.add(8);
		arr.add(6);
		arr.add(4);
		arr.add(1);
		arr.add(7);
		QuickSortImpl impl = new QuickSortImpl();
		System.out.println("Array before Sorting" + arr.toString());
		System.out.println("Array after sorting" + impl.quickSortArray(arr).toString());
	}

}
