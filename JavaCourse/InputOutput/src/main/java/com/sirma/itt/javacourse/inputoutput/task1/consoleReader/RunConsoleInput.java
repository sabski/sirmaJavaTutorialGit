package com.sirma.itt.javacourse.inputoutput.task1.consoleReader;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class that accepts console input with different variations.
 * 
 * @author Simeon Iliev
 */
public class RunConsoleInput {

	/**
	 * The main method of the application.
	 * 
	 * @param args
	 *            the main method arguments
	 */
	public static void main(String[] args) {

		InputUtils.printConsoleMessage("This is only test please input correct values.");
		InputUtils.printConsoleMessage("This is only test  please input number.");
		InputUtils.printConsoleMessage("Inputed int  = " + InputUtils.readInt());
		InputUtils.printConsoleMessage("This is only test  please input char.");
		InputUtils.printConsoleMessage("Inputed char  = " + InputUtils.readChar());
		InputUtils.printConsoleMessage("This is only test  please input float.");
		InputUtils.printConsoleMessage("Inputed float  = " + InputUtils.readFlaot());
		InputUtils.printConsoleMessage("This is only test  please input String.");
		InputUtils.printConsoleMessage("Inputed string  = " + InputUtils.readString());

	}

}
