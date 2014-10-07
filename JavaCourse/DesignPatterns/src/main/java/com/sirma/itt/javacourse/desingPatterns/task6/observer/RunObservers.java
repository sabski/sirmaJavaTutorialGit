package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.Item;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.ItemsInStock;
import com.sirma.itt.javacourse.desingPatterns.task6.observer.observation.ItemsOutOfStock;

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
		ItemObserverable item;
		while (true) {
			IOUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter item name");
					item = new ItemObserverable(IOUtils.readLine());
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
						ItemObserverable item2 = (ItemObserverable) missingInventory.getList().get(num);
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
						ItemObserverable item2 = (ItemObserverable) stock.getList().get(number);
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
