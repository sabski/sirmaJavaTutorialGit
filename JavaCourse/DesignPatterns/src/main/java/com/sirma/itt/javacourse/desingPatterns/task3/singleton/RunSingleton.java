package com.sirma.itt.javacourse.desingPatterns.task3.singleton;

import com.sirma.itt.javacourse.InputUtils;

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

		InputUtils.printConsoleMessage("Creating first object ");
		MySingletonClass.getInstance();
		InputUtils.printConsoleMessage("Creating second object ");
		MySingletonClass.getInstance();

	}
}
