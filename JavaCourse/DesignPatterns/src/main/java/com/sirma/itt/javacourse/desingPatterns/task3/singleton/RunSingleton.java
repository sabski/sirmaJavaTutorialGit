package com.sirma.itt.javacourse.desingPatterns.task3.singleton;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running singleton use example
 * 
 * @author Simeon Iliev
 */
public class RunSingleton {

	/**
	 * Main method for the application.
	 * 
	 * @param args
	 *            Arguments for the main method
	 */
	public static void main(String[] args) {

		IOUtils.printConsoleMessage("Creating first object ");
		MySingletonClass.getInstance();
		IOUtils.printConsoleMessage("Creating second object ");
		MySingletonClass.getInstance();

	}
}
