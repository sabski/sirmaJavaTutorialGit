package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Item that is observed.
 * 
 * @author Simeon Iliev
 */
public class Inventory {

	private List<Item> inventory;

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
	 * Constructor.
	 */
	public Inventory() {
		this.inventory = new ArrayList<Item>();
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

	/**
	 * Prints the current items in inventory.
	 */
	public String printInventory() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inventory.size(); i++) {
			builder.append(i + ": " + inventory.get(i).getName());
		}
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return printInventory();
	}
	
	
}
