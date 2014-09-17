package com.sirma.itt.javacourse.exceptions.task1.stringCalculator;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running the String calculator.
 * 
 * @author simeon
 */
public class RunStringCalculator {

	private static Logger log = Logger.getLogger(RunStringCalculator.class.getName());

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
		String result = null;
		do {
			IOUtils.printConsoleMessage("Input only one number on a line. ");

			IOUtils.printConsoleMessage("Please input number value for the first number ");
			firstBigNumber = IOUtils.readLine();

			IOUtils.printConsoleMessage("Please input number value for the second number ");
			secondBigNumber = IOUtils.readLine();

			try {
				result = calculator.sumStrings(firstBigNumber, secondBigNumber);
			} catch (NumberFormatException e) {
				log.error(e.getMessage(), e);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage(), e);
			}
		} while (result == null);
		IOUtils.printConsoleMessage("Result is " + result);

	}
}
