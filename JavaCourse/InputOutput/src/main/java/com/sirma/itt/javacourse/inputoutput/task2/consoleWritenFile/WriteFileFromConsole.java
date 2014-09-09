package com.sirma.itt.javacourse.inputoutput.task2.consoleWritenFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Writes a file from the input in the console.
 * 
 * @author simeon
 */
public class WriteFileFromConsole {

	public static final String DIR_LOCALE = "target/temp/";

	/**
	 * Writes a text to a file that the user specifies in the console input.
	 */
	public void writeFile(String fileName) {
		
		File file = new File(DIR_LOCALE + fileName);
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			if (!file.exists()) {
				new File(DIR_LOCALE).mkdir();
				file.createNewFile();
			}

			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			IOUtils.printConsoleMessage("Start input for file : ");
			readAndWriteContentForFile(bufferedWriter);
			IOUtils.printConsoleMessage("File path is  : " + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error writing the file : " + e.getMessage());
		} finally {

			if (bufferedWriter != null && fileWriter != null) {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (IOException e) {
					IOUtils.printConsoleMessage("Couldn't close streams : " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Reads the console input until "." is entered then the console input is return as one single
	 * String.
	 * 
	 * @param bufferedWriter
	 *            writer that is writes directly to the file.
	 * @throws IOException
	 *             if there is a problem with the buffer.
	 */
	private void readAndWriteContentForFile(BufferedWriter bufferedWriter) throws IOException {
		String line = null;
		do {
			line = IOUtils.readLine();
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		} while (!".".equals(line));

	}
}
