package com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Runs the file writer class.
 * 
 * @author simeon
 */
public class RunFileWriter {

	/**
	 * Runs the console reader.
	 * 
	 * @param args
	 *            the argument for the main method.
	 */
	public static void main(String[] args) {
		WriteFileFromConsole writer = new WriteFileFromConsole();
		InputUtils.printConsoleMessage("Input file name : ");
		writer.writeFile(InputUtils.readLine());
	}

}
