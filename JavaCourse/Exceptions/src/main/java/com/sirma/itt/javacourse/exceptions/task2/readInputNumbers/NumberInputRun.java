package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.MathUtil;

/**
 * Runner class that is designed to catch a NumericInputException
 * 
 * @author simeon
 */
public class NumberInputRun {

	private static Logger log = Logger.getLogger(NumberInputRun.class.getName());

	/**
	 * Main method to run the program.
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {
		InputUtils.printConsoleMessage("Input numbers in the interval 0 - 100\n Program will stop when you enter -1");
		int num = 0;
		do {
			try {
				num = InputUtils.readInt();
				InputUtils.printConsoleMessage("" + num);
				if (!MathUtil.checkInputRange(0, 100, num)) {
					throw new NumericInputException();
				} else {
					InputUtils.printConsoleMessage("Try again");
				}

			} catch (NumericInputException e) {
				log.error("Input was not in valid range", e);
			}
		} while (num != -1);
	}
}
