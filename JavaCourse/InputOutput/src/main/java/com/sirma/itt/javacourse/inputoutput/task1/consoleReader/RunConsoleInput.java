package com.sirma.itt.javacourse.inputoutput.task1.consoleReader;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that accepts console input with different variations.
 * 
 * @author simeon
 */
public class RunConsoleInput {

	/**
	 * The main method of the application.
	 * 
	 * @param args
	 *            the main method arguments
	 */
	public static void main(String[] args) {

		IOUtils.printConsoleMessage("This is only test plese input correct values.");
		IOUtils.printConsoleMessage("This is only test  plese input number.");
		IOUtils.printConsoleMessage("Inputed int  = " + IOUtils.readInt());
		IOUtils.printConsoleMessage("This is only test  plese input char.");
		IOUtils.printConsoleMessage("Inputed char  = " + IOUtils.readChar());
		IOUtils.printConsoleMessage("This is only test  plese input flaot.");
		IOUtils.printConsoleMessage("Inputed float  = " + IOUtils.readFlaot());
		IOUtils.printConsoleMessage("This is only test  plese input String.");
		IOUtils.printConsoleMessage("Inputed string  = " + IOUtils.readString());
		
	}

}
