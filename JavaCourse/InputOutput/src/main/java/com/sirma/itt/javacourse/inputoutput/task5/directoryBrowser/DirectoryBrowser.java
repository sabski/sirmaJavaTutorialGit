package com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser;

import java.io.File;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that display the structure of a given directory.
 * 
 * @author simeon
 */
public class DirectoryBrowser {

	/**
	 * Displays the structure of a given directory.
	 * 
	 * @param path
	 *            the path to the directory.
	 */
	public void listContent(String path) {
		File file = new File(path);
		if (!file.isDirectory() && !file.isFile()) {
			path = System.getProperty("user.home");
			file = new File(path);

		}

		if (file.isFile()) {
			IOUtils.printConsoleMessage("The path you entered leeds to a file " + path);
			return;
		}
		IOUtils.printConsoleMessage("The content of folder " + path + " is :");
		File[] list = file.listFiles();
		for (File f : list) {
			IOUtils.printConsoleMessage(f.getName());
		}
	}
}
