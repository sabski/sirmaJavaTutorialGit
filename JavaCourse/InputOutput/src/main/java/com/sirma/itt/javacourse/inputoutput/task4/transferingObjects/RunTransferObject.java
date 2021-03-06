package com.sirma.itt.javacourse.inputoutput.task4.transferingObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile.WriteFileFromConsole;

/**
 * Class for running the Transfer object class.
 * 
 * @author simeon
 */
public class RunTransferObject {

	private static Logger log = Logger.getLogger(RunTransferObject.class.getName());

	/**
	 * The main method for the application.
	 * 
	 * @param args
	 *            the argument for the main method.
	 * @throws IOException
	 *             if the file we want to create can't be created.
	 */
	public static void main(String[] args) throws IOException {

		try {
			InputUtils.printConsoleMessage("Input the name of the file to be created to start transferring bytes");
			String fileName = InputUtils.readLine();
			WriteFileFromConsole writer = new WriteFileFromConsole();
			writer.writeFile(fileName);
			InputStream input = new FileInputStream(WriteFileFromConsole.DIR_LOCALE + fileName);
			InputUtils.printConsoleMessage("Input file name to write data.");
			String targetFile = InputUtils.readLine();
			File temp = new File(WriteFileFromConsole.DIR_LOCALE + targetFile);
			if (!temp.exists()) {
				temp.createNewFile();
			}
			OutputStream output = new FileOutputStream(WriteFileFromConsole.DIR_LOCALE + targetFile);
			TransferObject transfer = new TransferObject(input, output);
			InputUtils.printConsoleMessage("Input the number of bytes to transfer from the files");
			int numberOfBites = InputUtils.readInt();
			InputUtils.printConsoleMessage("Input offset for the stream.");
			int offset = InputUtils.readInt();
			InputUtils.printConsoleMessage("Number of transfered bytes = "
					+ transfer.transfer(numberOfBites, offset));
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		}

	}

}
