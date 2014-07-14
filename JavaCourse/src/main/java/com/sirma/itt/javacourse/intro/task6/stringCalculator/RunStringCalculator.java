package com.sirma.itt.javacourse.intro.task6.stringCalculator;

import com.sirma.itt.javacourse.InputUtil;

/**
 * Class for running the String calculator.
 * 
 * @author simeon
 */
public class RunStringCalculator {

	/**
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCalculator calculator = new StringCalculator();
		String firstBigNumber = null;
		String secondBigNumber = null;
		do {
			System.out.println("Plese input number values ");
			firstBigNumber = InputUtil.readLine();
			secondBigNumber = InputUtil.readLine();
		} while (!(InputUtil.validateStringWithREgex(InputUtil.REGEX_VALIDATOR_NUMBERS_ONLY,
				firstBigNumber) && InputUtil.validateStringWithREgex(
				InputUtil.REGEX_VALIDATOR_NUMBERS_ONLY, secondBigNumber)));
		System.out.println(" 1 = " + firstBigNumber + " 2 = " + secondBigNumber);
		System.out.println(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
