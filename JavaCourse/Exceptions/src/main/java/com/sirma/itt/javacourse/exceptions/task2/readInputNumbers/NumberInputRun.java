package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class that is designed to catch a NumericInputException
 * 
 * @author simeon
 */
public class NumberInputRun {

	/**
	 * Main method to run the program.
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtils.printConsoleMessage("Input numbers in the interval 0 - 100");

			while (true) {
				int num = IOUtils.readInt();
				IOUtils.printConsoleMessage("" + num);
				runInput(num);
			}
		} catch (NumericInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the given value is within range otherwise throws an exception
	 * 
	 * @param num
	 *            the number to be checked if it is specific range.
	 * @throws NumericInputException
	 */
	public static void runInput(int num) throws NumericInputException {

		if (0 > num || num > 100) {
			throw new NumericInputException();
		} else {
			IOUtils.printConsoleMessage("Try again :P");
		}
	}
}
