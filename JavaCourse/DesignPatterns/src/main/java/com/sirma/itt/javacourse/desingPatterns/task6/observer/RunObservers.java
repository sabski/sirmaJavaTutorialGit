package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

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
		inventory.attachObserver(new CurrentInventoryObserverImpl());
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter item name");
					inventory.deliverItems(new Item(IOUtils.readLine()));
					break;
				case 2:
					IOUtils.printConsoleMessage("Deliver item  number :\n"
							+ inventory.printInventory());
					int num = IOUtils.readInt();
					inventory.deliverItems(inventory.getInventory().get(num));
					break;
				case 3:
					IOUtils.printConsoleMessage("Sell item  number :\n"
							+ inventory.printInventory());
					int number = IOUtils.readInt();
					inventory.sellItems(inventory.getInventory().get(number));
					break;
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
