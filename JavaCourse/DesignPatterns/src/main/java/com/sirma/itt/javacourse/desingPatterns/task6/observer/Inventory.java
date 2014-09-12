package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Item that is observed.
 * 
 * @author Simeon Iliev
 */
public class Inventory {

	private List<Item> inventory;

	/**
	 * Prints the current items in inventory.
	 */
	public void printInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			IOUtils.printConsoleMessage(i + ": " + inventory.get(i).getName() + "\n");
		}
	}

	/**
	 * Getter method for inventory.
	 * 
	 * @return the inventory
	 */
	public List<Item> getInventory() {
		return inventory;
	}

	/**
	 * Setter method for inventory.
	 * 
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	/**
	 * Adds an item that was delivered.
	 * 
	 * @param item
	 *            that is delivered
	 */
	public void deliverdItems(Item item) {
		inventory.add(item);
	}

	/**
	 * The item is sold out and should be removed from the inventory.
	 * 
	 * @param item
	 *            that is to be removed.
	 */
	public void sellItems(Item item) {
		if (inventory.contains(item)) {
			inventory.remove(item);
		}

	}
}
