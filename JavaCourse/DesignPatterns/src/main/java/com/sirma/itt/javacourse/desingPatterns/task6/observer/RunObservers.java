package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for observers.
 * 
 * @author Simeon Iliev
 */
public class RunObservers {

	/**
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {

				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("");
					break;
			}
		}

	}

}
