package com.sirma.itt.javacourse.inputoutput.task5.DirectoryBrowser;

import com.sirma.itt.javacourse.Utils;

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
		Utils.printConsoleMessage("Inout directory path");
		browser.listContent(Utils.readLine());
	}

}
