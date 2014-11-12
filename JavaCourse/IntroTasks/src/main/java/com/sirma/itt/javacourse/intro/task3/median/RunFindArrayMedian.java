package com.sirma.itt.javacourse.intro.task3.median;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Runner class for FindArrayMedion.
 * 
 * @author simeon
 */
public class RunFindArrayMedian {

	/**
	 * Main method for the running the FindArrayMedian class.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		FindArrayMedian median = new FindArrayMedian();
		List<Integer> list = new ArrayList<Integer>();

		list = InputUtils.inputListOfIntegers();

		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		InputUtils.printConsoleMessage("The median of the array is " + median.findMedian(arr));
	}
}
