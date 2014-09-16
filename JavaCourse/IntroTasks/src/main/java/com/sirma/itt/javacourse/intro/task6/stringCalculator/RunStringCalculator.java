package com.sirma.itt.javacourse.intro.task6.stringCalculator;

import com.sirma.itt.javacourse.IOUtils;

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
		StringCalculator calculator = new StringCalculator();
		String firstBigNumber = null;
		String secondBigNumber = null;
		IOUtils.printConsoleMessage("Input only one number on a line. ");
		do {
			IOUtils.printConsoleMessage("Plese input number value for the first number ");
			firstBigNumber = IOUtils.readLine();
			IOUtils.printConsoleMessage("Plese input number value for the second number ");
			secondBigNumber = IOUtils.readLine();
		} while (!(IOUtils.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_NUMBERS_ONLY,
				firstBigNumber + secondBigNumber)));
		IOUtils.printConsoleMessage(" Firts number is  " + firstBigNumber + " Second number is "
				+ secondBigNumber);
		IOUtils.printConsoleMessage(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
