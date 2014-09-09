package com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runs the file writer class.
 * 
 * @author simeon
 */
public class RunFileWriter {

	/**
	 * Runs the console reder.
	 * 
	 * @param args
	 *            the argument for the main method.
	 */
	public static void main(String[] args) {
		WriteFileFromConsole writer = new WriteFileFromConsole();
		IOUtils.printConsoleMessage("Input file name : ");
		writer.writeFile(IOUtils.readLine());
	}

}
