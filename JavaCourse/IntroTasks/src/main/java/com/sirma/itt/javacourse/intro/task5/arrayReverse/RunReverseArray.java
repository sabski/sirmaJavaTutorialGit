package com.sirma.itt.javacourse.intro.task5.arrayReverse;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

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
		arr = IOUtils.inputListOfIntegers();

		IOUtils.printConsoleMessage("Array before : " + arr);
		IOUtils.printConsoleMessage("Array after : " + reverse.reverseArray(arr));
	}
}
