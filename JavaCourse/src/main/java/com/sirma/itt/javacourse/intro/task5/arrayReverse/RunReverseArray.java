package com.sirma.itt.javacourse.intro.task5.arrayReverse;

import java.util.ArrayList;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for Running the ReverseArray class.
 * 
 * @author simeon
 */
public class RunReverseArray {

	/**
	 * Method for running the ReverseArray class.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ReverseArray reverse = new ReverseArray();

		arr = Utils.inputArrayListOfIntegers();

		System.out.println(arr.toString());
		System.out.println(reverse.reverseArray(arr).toString());
	}
}
