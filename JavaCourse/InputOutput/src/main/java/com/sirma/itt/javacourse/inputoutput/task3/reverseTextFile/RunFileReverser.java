package com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;

/**
 * Class that runs the file reverser.
 * 
 * @author simeon
 */
public class RunFileReverser {

	private static Logger log = Logger.getLogger(RunFileReverser.class.getName());

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
			InputUtils.printConsoleMessage("Input the name of the file you want to create and then reverse :");
			String fileName = InputUtils.readLine();
			writer.writeFile(fileName);
			reverser.reverseFileContent(WriteFileFromConsole.DIR_LOCALE + fileName);
			InputUtils.readFile(WriteFileFromConsole.DIR_LOCALE + fileName);
		} catch (FileNotFoundException e) {
			log.error("File coudn't be found", e);
		}
	}
}
