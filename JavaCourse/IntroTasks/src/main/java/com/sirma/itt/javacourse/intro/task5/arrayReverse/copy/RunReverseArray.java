package com.sirma.itt.javacourse.intro.task5.arrayReverse.copy;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> arr = new ArrayList<Integer>();
		ReverseArray reverse = new ReverseArray();
		arr = Utils.inputArrayListOfIntegers();

		Utils.printConsoleMessage("Array before : " + arr);
		Utils.printConsoleMessage("Array after : " + reverse.reverseArray(arr));
	}
}
