package com.sirma.itt.javacourse.intro.arraySorting;

import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner scaner = new Scanner(System.in);
		System.out.println("Plese input numbers for the array");
		numbersCount = scaner.nextInt();
		for (int i = 0; i < numbersCount; i++) {
			arr.add(scaner.nextInt());
		}
		scaner.close();
		System.out.println("Array before sorting " + arr.toString());
		System.out.println("Array after sorting " + impl.quickSortArray(arr).toString());
	}

}
