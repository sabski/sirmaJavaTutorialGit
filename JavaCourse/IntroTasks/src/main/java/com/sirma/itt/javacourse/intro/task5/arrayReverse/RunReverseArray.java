package com.sirma.itt.javacourse.intro.task5.arrayReverse;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

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
		List<Integer> arr = new ArrayList<Integer>();
		ReverseArray reverse = new ReverseArray();
		arr = InputUtils.inputListOfIntegers();

		InputUtils.printConsoleMessage("Array before : " + arr);
		InputUtils.printConsoleMessage("Array after : " + reverse.reverseArray(arr));
	}
}
