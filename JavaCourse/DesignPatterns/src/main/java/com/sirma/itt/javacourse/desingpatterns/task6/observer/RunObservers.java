package com.sirma.itt.javacourse.desingpatterns.task6.observer;

import com.sirma.itt.javacourse.InputUtils;

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
			InputUtils.printConsoleMessage("Inventory operations : \n"
					+ "1 : Create new Stock item \n" + "2 : Deliver item \n" + "3 : Sell Item \n"
					+ "-1 : Exit");
			int key = InputUtils.readInt();
			switch (key) {
				case 1:
					InputUtils.printConsoleMessage("Enter item name");
					item = new ItemObservable(InputUtils.readLine());
					item.attachObserver(stock);
					item.attachObserver(missingInventory);
					InputUtils.printConsoleMessage("Observer count " + item.getObserverCount());
					item.deliverItem();
					break;
				case 2:
					InputUtils.printConsoleMessage("Input number of item to be delivered");
					InputUtils.printConsoleMessage(missingInventory.getList().toString());
					int num = InputUtils.readInt();
					try {
						ItemObservable item2 = (ItemObservable) missingInventory.getList().get(num);
						item2.deliverItem();
					} catch (IndexOutOfBoundsException e) {
						InputUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case 3:
					InputUtils.printConsoleMessage("Input number of the item to sell : ");
					InputUtils.printConsoleMessage(stock.getList().toString());
					int number = InputUtils.readInt();
					try {
						ItemObservable item2 = (ItemObservable) stock.getList().get(number);
						item2.sellItem();
					} catch (IndexOutOfBoundsException e) {
						InputUtils.printConsoleMessage("Number was not in valid range");
					}
					break;
				case -1:
					System.exit(0);
					break;
				default:
					InputUtils.printConsoleMessage("Invalid menu operation.");
					break;
			}
		}
	}

}
