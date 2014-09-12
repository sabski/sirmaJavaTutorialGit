package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for observers.
 * 
 * @author Simeon Iliev
 */
public class RunObservers {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		StockToOrder order = new StockToOrder();
		StockObserver observer = new StockObserverImpl(inventory, order);
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter item name");
					Item item = new Item(IOUtils.readLine());
					observer.deliveryUpdate(item);
					break;
				case 2:
					IOUtils.printConsoleMessage("Input number of item to be delivered");
					order.printMissingStock();
					int num = IOUtils.readInt();
					try {
						Item item2 = order.getOutOfStockItems().get(num);
						observer.deliveryUpdate(item2);
					} catch (IndexOutOfBoundsException e) {
						IOUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case 3:
					IOUtils.printConsoleMessage("Input number of the item to sell : ");
					inventory.printInventory();
					int number = IOUtils.readInt();
					try {
						observer.purcheaseUpdate(inventory.getInventory().get(number));
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
