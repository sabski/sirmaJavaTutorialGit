package com.sirma.itt.javacourse.intro.task6.stringCalculator;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.StringUtil;

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
		InputUtils.printConsoleMessage("Input only one number on a line. ");
		do {
			InputUtils.printConsoleMessage("Please input number value for the first number ");
			firstBigNumber = InputUtils.readLine();
			InputUtils.printConsoleMessage("Please input number value for the second number ");
			secondBigNumber = InputUtils.readLine();
		} while (!(StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_NUMBERS_ONLY,
				firstBigNumber + secondBigNumber)));
		InputUtils.printConsoleMessage(" First number is  " + firstBigNumber + " Second number is "
				+ secondBigNumber);
		InputUtils.printConsoleMessage(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
