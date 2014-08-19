package com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.Utils;

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
	 */
	public void reverseFile(String fileName) {

		File file = new File(fileName);
		if (!file.exists() || file.isDirectory()) {
			Utils.printConsoleMessage("Invalid file name");
			return;
		}
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {

			reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				Utils.printConsoleMessage(line);
				stringBuffer.append(line + "\n");

			}
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(stringBuffer.reverse().toString().replaceFirst("\n", ""));

		} catch (IOException e) {
			e.printStackTrace();
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
