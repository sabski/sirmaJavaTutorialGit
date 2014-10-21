package com.sirma.itt.javacourse.inputoutput.task5.directoryBrowser;

import java.io.File;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that display the structure of a given directory.
 * 
 * @author Simeon Iliev
 */
public class DirectoryBrowser {

	private final Logger log = Logger.getLogger(DirectoryBrowser.class.getName());

	/**
	 * Displays the structure of a given directory.
	 * 
	 * @param path
	 *            the path to the directory.
	 */
	public String listContent(String path) {
		StringBuilder builder = new StringBuilder();
		File file = new File(path);
		if (!file.isDirectory() && !file.isFile()) {
			path = System.getProperty("user.home");
			file = new File(path);

		}

		if (file.isFile()) {
			log.info("The path you entered leads to a file " + path);
			builder.append(path);
			return builder.toString();
		}
		log.info("The content of folder " + path + " is :");
		File[] list = file.listFiles();
		for (File f : list) {
			IOUtils.printConsoleMessage(f.getName());
			builder.append(f.getName() + "; ");
		}
		return builder.toString();
	}
}
