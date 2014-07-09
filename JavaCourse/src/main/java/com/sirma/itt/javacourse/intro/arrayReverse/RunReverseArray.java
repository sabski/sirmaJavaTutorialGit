package com.sirma.itt.javacourse.intro.arrayReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for Running the ReverseArray class.
 * 
 * @author simeon
 */
public class RunReverseArray {

	/**
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ReverseArray reverse = new ReverseArray();
		int numbersCount = 0;
		Scanner scaner = new Scanner(System.in);
		System.out.println("Plese input numbers for the array");
		numbersCount = scaner.nextInt();
		for (int i = 0; i < numbersCount; i++) {
			arr.add(scaner.nextInt());
		}
		scaner.close();
		System.out.println(arr.toString());
		System.out.println(reverse.reverseArray(arr).toString());
	}

}
