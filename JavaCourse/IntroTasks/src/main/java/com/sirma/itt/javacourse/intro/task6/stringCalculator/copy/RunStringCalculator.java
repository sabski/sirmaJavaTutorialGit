package com.sirma.itt.javacourse.intro.task6.stringCalculator.copy;

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
		Utils.printConsoleMessage("Input only one number on a line. ");
		do {
			Utils.printConsoleMessage("Plese input number value for the first number ");
			firstBigNumber = Utils.readLine();
			Utils.printConsoleMessage("Plese input number value for the second number ");
			secondBigNumber = Utils.readLine();
		} while (!(Utils.validateStringWithREgex(Utils.REGEX_VALIDATOR_NUMBERS_ONLY, firstBigNumber
				+ secondBigNumber)));
		Utils.printConsoleMessage(" Firts number is  " + firstBigNumber + " Second number is "
				+ secondBigNumber);
		Utils.printConsoleMessage(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
