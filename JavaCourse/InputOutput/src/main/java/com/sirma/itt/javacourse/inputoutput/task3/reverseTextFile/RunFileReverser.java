package com.sirma.itt.javacourse.inputoutput.task3.reverseTextFile;

import java.io.FileNotFoundException;

import com.sirma.itt.javacourse.IOUtils;

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
	 *            argument for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReverser reverser = new FileReverser();
		IOUtils.printConsoleMessage("Input the name of the file you want to reverse.");
		try {
			reverser.reverseFileContent(IOUtils.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
