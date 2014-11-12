package com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class for displaying the structure of a directory.
 * 
 * @author Simeon Iliev
 */
public class RunDirectoryBrowser {

	/**
	 * The main method of the application.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		DirectoryBrowser browser = new DirectoryBrowser();
		InputUtils.printConsoleMessage("Input directory path");
		browser.listContent(InputUtils.readLine());
	}

}
