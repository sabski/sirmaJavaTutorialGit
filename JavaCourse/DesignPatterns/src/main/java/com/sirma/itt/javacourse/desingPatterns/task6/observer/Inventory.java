package com.sirma.itt.javacourse.desingPatterns.task6.observer;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Item that is observed.
 * 
 * @author Simeon Iliev
 */
public class Inventory extends StockItemObservable {

	private List<Item> inventory;

	private List<StockObserver> observers;

	/**
	 * Basic constructor.
	 */
	public Inventory() {
		super();
		observers = new ArrayList<StockObserver>();
		inventory = new ArrayList<Item>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void attachObserver(StockObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void detachObserver(StockObserver observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	public void deliverItems(Item item) {
		if (!inventory.contains(item)) {
			inventory.add(item);
		}
		IOUtils.printConsoleMessage("Delivering item");
		notifyOnDelyvery(item);
	}

	private void notifyOnDelyvery(Item item) {
		for (StockObserver observer : observers) {
			observer.deliveryUpdate(item);
		}
	}

	public void sellItems(Item item) {
		IOUtils.printConsoleMessage("Selling item");
		notifyOnSell(item);
	}

	private void notifyOnSell(Item item) {
		for (StockObserver observer : observers) {
			observer.purcheaseUpdate(item);
		}
	}

	public String printInventory() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inventory.size(); i++) {
			builder.append(i + ": " + inventory.get(i).getName() + "\n");
		}
		return builder.toString();
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
	 * @param inventory the inventory to set
	 */
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

}
