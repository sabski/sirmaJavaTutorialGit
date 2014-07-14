package com.sirma.itt.javacourse.intro.task5.arrayReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sirma.itt.javacourse.InputUtil;

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
		System.out.println("Plese input numbers for the array");
		numbersCount = InputUtil.readLineNumber();
		for (int i = 0; i < numbersCount; i++) {
			arr.add(InputUtil.readLineNumber());
		}
		System.out.println(arr.toString());
		System.out.println(reverse.reverseArray(arr).toString());
	}
}
