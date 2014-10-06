package com.sirma.itt.javacourse.desingPatterns.task6.observer.observation;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class.
 * 
 * @author Simeon Iliev
 */
public class RunObservernPattern {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		ItemsInStock stock = new ItemsInStock();
		ItemsOutOfStock missingInventory = new ItemsOutOfStock();
		Item item;
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter item name");
					item = new Item(IOUtils.readLine());
					item.addObserver(stock);
					item.addObserver(missingInventory);
					IOUtils.printConsoleMessage("Observer count " + item.countObservers());
					item.deliverItem();
					break;
				case 2:
					IOUtils.printConsoleMessage("Input number of item to be delivered");
					IOUtils.printConsoleMessage(missingInventory.getItemsOutOfStock().toString());
					int num = IOUtils.readInt();
					try {
						Item item2 = (Item) missingInventory.getItemsOutOfStock().get(num);
						item2.deliverItem();
					} catch (IndexOutOfBoundsException e) {
						IOUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case 3:
					IOUtils.printConsoleMessage("Input number of the item to sell : ");
					IOUtils.printConsoleMessage(stock.getItemsInStock().toString());
					int number = IOUtils.readInt();
					try {
						Item item2 = (Item) stock.getItemsInStock().get(number);
						item2.sellItem();
					} catch (IndexOutOfBoundsException e) {
						IOUtils.printConsoleMessage("Number was not in valid range");
					}
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
