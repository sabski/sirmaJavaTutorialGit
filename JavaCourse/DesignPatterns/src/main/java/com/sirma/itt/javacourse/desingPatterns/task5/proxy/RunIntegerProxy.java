package com.sirma.itt.javacourse.desingPatterns.task5.proxy;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for the proxy design pattern.
 * 
 * @author Simeon Iliev
 */
public class RunIntegerProxy {

	/**
	 * Main method for the application.
	 * 
	 * @param args
	 *            Arguments for the main method.
	 */
	public static void main(String[] args) {

		IntegerProxy proxy = new IntegerProxy();

		IOUtils.printConsoleMessage("Getting instance from proxy.");
		int aNumber = proxy.loadInt();
		IOUtils.printConsoleMessage("Default value " + aNumber);
		IOUtils.printConsoleMessage("input new value");
		aNumber = IOUtils.readInt();
		IOUtils.printConsoleMessage("New value " + aNumber);
	}

}
