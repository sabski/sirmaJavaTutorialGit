package com.sirma.itt.javacourse.exceptions.task1.stringCalculator;

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
		try {
			Utils.printConsoleMessage("Plese input number value for the first number ");
			firstBigNumber = Utils.readLine();

			Utils.printConsoleMessage("Plese input number value for the second number ");
			// secondBigNumber = Utils.readLine();

			Utils.printConsoleMessage("Result is"
					+ calculator.sumStrings(firstBigNumber, secondBigNumber));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
