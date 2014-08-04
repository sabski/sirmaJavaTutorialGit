package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import com.sirma.itt.javacourse.Utils;

/**
 * @author simeon
 */
public class NumberInputRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Utils.printConsoleMessage("Input numbers in the interval 0 - 100");

			while (true) {
				int num = Utils.readLineNumber();
				Utils.printConsoleMessage("" + num);
				runInput(num);
			}
		} catch (NumericInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void runInput(int num) throws NumericInputException {

		if (0 > num || num > 100) {
			throw new NumericInputException();
		} else {
			Utils.printConsoleMessage("Try again :P");
		}
	}
}
