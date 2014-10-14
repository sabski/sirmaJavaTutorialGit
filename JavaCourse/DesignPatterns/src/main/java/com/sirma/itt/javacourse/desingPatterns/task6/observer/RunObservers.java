package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class.
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

		StockObserver stock = new StockObserver();
		OrderObesrver missingInventory = new OrderObesrver();
		ItemObservable item;
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter item name");
					item = new ItemObservable(IOUtils.readLine());
					item.attachObserver(stock);
					item.attachObserver(missingInventory);
					IOUtils.printConsoleMessage("Observer count " + item.getObserverCount());
					item.deliverItem();
					break;
				case 2:
					IOUtils.printConsoleMessage("Input number of item to be delivered");
					IOUtils.printConsoleMessage(missingInventory.getList().toString());
					int num = IOUtils.readInt();
					try {
						ItemObservable item2 = (ItemObservable) missingInventory.getList().get(num);
						item2.deliverItem();
					} catch (IndexOutOfBoundsException e) {
						IOUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case 3:
					IOUtils.printConsoleMessage("Input number of the item to sell : ");
					IOUtils.printConsoleMessage(stock.getList().toString());
					int number = IOUtils.readInt();
					try {
						ItemObservable item2 = (ItemObservable) stock.getList().get(number);
						item2.sellItem();
					} catch (IndexOutOfBoundsException e) {
						IOUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("Invalid menu operation.");
					break;
			}
		}
	}

}
