package com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for displaing the structure of a directory.
 * 
 * @author simeon
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
		IOUtils.printConsoleMessage("Input directory path");
		browser.listContent(IOUtils.readLine());
	}

}
