package com.sirma.itt.javacourse.inputoutput.task1.consoleReader;

import com.sirma.itt.javacourse.Utils;

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

		Utils.printConsoleMessage("This is only test plese input correct values.");
		Utils.printConsoleMessage("This is only test  plese input number.");
		Utils.printConsoleMessage("Inputed int  = " + Utils.readInt());
		Utils.printConsoleMessage("This is only test  plese input char.");
		Utils.printConsoleMessage("Inputed char  = " + Utils.readChar());
		Utils.printConsoleMessage("This is only test  plese input flaot.");
		Utils.printConsoleMessage("Inputed float  = " + Utils.readFlaot());
		Utils.printConsoleMessage("This is only test  plese input String.");
		Utils.printConsoleMessage("Inputed string  = " + Utils.readString());
		
	}

}
