package com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser;

import java.io.File;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that display the structure of a given directory.
 * 
 * @author simeon
 */
public class DirectoryBrowser {

	private Logger log = Logger.getLogger(DirectoryBrowser.class.getName());

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
			log.info("The path you entered leads to a file " + path);
			return;
		}
		log.info("The content of folder " + path + " is :");
		File[] list = file.listFiles();
		for (File f : list) {
			IOUtils.printConsoleMessage(f.getName());
		}
	}
}
