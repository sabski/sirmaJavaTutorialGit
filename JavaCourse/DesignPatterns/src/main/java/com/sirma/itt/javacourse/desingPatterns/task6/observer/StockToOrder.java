package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that hold information for the missing items in the inventory.
 * 
 * @author Simeon Iliev
 */
public class StockToOrder {

	private List<Item> outOfStockItems;

	/**
	 * Receives a new item that went out of stock.
	 * 
	 * @param item
	 *            the item that went out of stock.
	 */
	public void receiveItem(Item item) {
		outOfStockItems.add(item);
	}

	/**
	 * Removes an item that was delivered and is in stock and should be removed from the out of
	 * stock list.
	 * 
	 * @param item
	 *            the item that is to be removed.
	 */
	public void removeItem(Item item) {
		if (outOfStockItems.contains(item)) {
			outOfStockItems.remove(item);
		}
	}

	/**
	 * Basic constructor.
	 */
	public StockToOrder() {
		this.outOfStockItems = new ArrayList<Item>();
	}

	/**
	 * Prints the contents of the out of stock item list.
	 */
	public void printMissingStock() {
		for (Item item : outOfStockItems) {
			IOUtils.printConsoleMessage("Item : " + item.getName());
		}
	}
}
