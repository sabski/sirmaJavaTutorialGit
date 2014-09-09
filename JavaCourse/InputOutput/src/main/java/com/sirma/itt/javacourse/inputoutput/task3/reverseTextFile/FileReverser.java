package com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Reverses the contents of a specific file.
 * 
 * @author simeon
 */
public class FileReverser {

	/**
	 * Reverses the contents of a specific text file.
	 * 
	 * @param fileName
	 *            the name of the file we want to reverse its content.
	 * @throws FileNotFoundException
	 *             if the name of the given file is not valid.
	 */
	public void reverseFileContent(String fileName) throws FileNotFoundException {

		File file = new File(fileName);
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {

			reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line + "\n");
			}
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(stringBuffer.reverse().toString().replaceFirst("\n", ""));

		} catch (IOException e) {
			IOUtils.printConsoleMessage("File couldn't be reversed : " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
