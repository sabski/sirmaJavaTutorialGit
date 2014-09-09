package com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile;

import java.io.FileNotFoundException;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;

/**
 * Class that runs the file reverser.
 * 
 * @author simeon
 */
public class RunFileReverser {

	/**
	 * Main method for FileReverser.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		FileReverser reverser = new FileReverser();
		WriteFileFromConsole writer = new WriteFileFromConsole();
		try {
			IOUtils.printConsoleMessage("Input the name of the file you want to create and then reverse :");
			String fileName = IOUtils.readLine();
			writer.writeFile(fileName);
			reverser.reverseFileContent(WriteFileFromConsole.DIR_LOCALE + fileName);
			IOUtils.readFile(WriteFileFromConsole.DIR_LOCALE + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
