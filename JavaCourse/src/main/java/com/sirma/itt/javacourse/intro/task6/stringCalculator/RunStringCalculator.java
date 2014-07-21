package com.sirma.itt.javacourse.intro.task6.stringCalculator;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for running the String calculator.
 * 
 * @author simeon
 */
public class RunStringCalculator {

	/**
	 * Main method for running the String calculator.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCalculator calculator = new StringCalculator();
		String firstBigNumber = null;
		String secondBigNumber = null;
		System.out.println("Input only one number on a line. ");
		do {
			System.out.println("Plese input number values ");
			firstBigNumber = Utils.readLine();
			System.out.println("Plese input number values ");
			secondBigNumber = Utils.readLine();
		} while (!(Utils.validateStringWithREgex(Utils.REGEX_VALIDATOR_NUMBERS_ONLY, firstBigNumber
				+ secondBigNumber)));
		System.out.println(" Firts number is  " + firstBigNumber + " Second number is "
				+ secondBigNumber);
		System.out.println(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
