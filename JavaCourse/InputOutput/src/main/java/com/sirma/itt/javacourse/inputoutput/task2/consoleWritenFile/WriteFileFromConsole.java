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

	/**
	 * Writes a text to a file that the user specifies in the console input.
	 */
	public void writeFile() {
		IOUtils.printConsoleMessage("Input file name : ");
		String name = IOUtils.readLine();

		File file;
		file = new File(name);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {

			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			IOUtils.printConsoleMessage("Start input for file : ");
			readInputForFile(bufferedWriter);
		} catch (IOException e) {
			System.err.println("Error writing the file : ");
			e.printStackTrace();
		} finally {

			if (bufferedWriter != null && fileWriter != null) {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
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
	private void readInputForFile(BufferedWriter bufferedWriter) throws IOException {
		String line = null;
		do {
			line = IOUtils.readLine();
			bufferedWriter.write(line + "\n");
		} while (!".".equals(line));

	}
}
