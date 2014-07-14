package com.sirma.itt.javacourse.intro.task3.median;

import java.util.ArrayList;
import java.util.Scanner;

import com.sirma.itt.javacourse.InputUtil;

/**
 * Runner class for FindArrayMedion.
 * 
 * @author simeon
 */
public class RunFindArrayMedian {

	/**
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindArrayMedian median = new FindArrayMedian();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int numbersCount = 0;
		System.out.println("Plese input the lenght of the array");
		numbersCount = InputUtil.readLineNumber();

		System.out.println("Plese input numbers for the array");
		for (int i = 0; i < numbersCount; i++) {
			list.add(InputUtil.readLineNumber());
		}
		int[] arr = new int[numbersCount];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		System.out.println("The median of the array is " + median.calculateMedian(arr));
		System.out.println("The median of the array is " + median.findMedian(arr));
	}
}
