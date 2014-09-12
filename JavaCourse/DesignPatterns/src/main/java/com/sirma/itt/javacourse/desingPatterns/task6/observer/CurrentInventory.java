package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Concrete implementation of the observer.
 * 
 * @author Simeon Iliev
 */
public class CurrentInventory {

	private List<Item> itemsInstock = new ArrayList<Item>();

	/**
	 * Items are delivered to the inventory.
	 * 
	 * @param item
	 *            that is delivered in the inventory.
	 */
	public void deliveryUpdate(Item item) {
		if (!itemsInstock.contains(item)) {
			itemsInstock.add(item);
			IOUtils.printConsoleMessage("Item delivered : " + item.getName());
		}

	}

	/**
	 * Constructor.
	 */
	public CurrentInventory() {
		itemsInstock = new ArrayList<Item>();
	}

	/**
	 * Purchase item from the inventory.
	 * 
	 * @param item
	 *            that is purchased.
	 */
	public void purcheaseUpdate(Item item) {
		if (itemsInstock.contains(item)) {
			itemsInstock.remove(item);
			IOUtils.printConsoleMessage("Removing item from inventory observer ");
		}
	}

}
