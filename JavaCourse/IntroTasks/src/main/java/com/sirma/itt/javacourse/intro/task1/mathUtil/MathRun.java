package com.sirma.itt.javacourse.intro.task1.mathUtil;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running the MAthUtil class.
 * 
 * @author simeon
 */
public class MathRun {

	/**
	 * Main method for the class and starting the program.
	 * 
	 * @param args
	 *            to be inserted in runtime
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathUtil math = new MathUtil();
		int count = 0;
		int[] numbers = new int[2];
		IOUtils.printConsoleMessage("Input 2 numbers for calculating the Greatest Common Divisor and Least Common Denominator \n"
				+ "input one number on a line.");
		while (count != 2) {
			IOUtils.printConsoleMessage("Please input number value for the " + (count + 1)
					+ " number");
			numbers[count] = IOUtils.readInt();
			count++;
		}

		IOUtils.printConsoleMessage("The Greatest Common Divisor of the numbers is "
				+ math.getGreatestCommonDivisor(numbers[0], numbers[1]));
		IOUtils.printConsoleMessage("The Least Common Denominator of the numbers is "
				+ math.getLeastCommonDenominator(numbers[0], numbers[1]));

	}
}
