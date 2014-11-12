package com.sirma.itt.javacourse.intro.task2.arrayUtil;

import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class for running the ArrayUtil class.
 * 
 * @author simeon
 */
public class RunArrayUtil {

	/**
	 * Main method for starting the the run arrayUtil class.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		int[] arr;
		ArrayUtil util = new ArrayUtil();

		List<Integer> list = InputUtils.inputListOfIntegers();

		arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		InputUtils.printConsoleMessage("The smallest ellement in the array is "
				+ util.getMinElement(arr));
		InputUtils.printConsoleMessage("The sum of the array is " + util.sum(arr));
		InputUtils.printConsoleMessage("The array will be printed in the line bellow. ");
		util.print(arr);
	}

}
