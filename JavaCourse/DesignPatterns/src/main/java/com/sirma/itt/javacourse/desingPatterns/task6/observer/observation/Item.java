package com.sirma.itt.javacourse.desingPatterns.task6.observer.observation;

import java.util.Observable;

/**
 * Item that is to be observed, for appering in the inventory.
 * 
 * @author Simeon Iliev
 */
public class Item extends Observable {

	private boolean inStock;
	private String name;

	/**
	 * Getter method for inStock.
	 * 
	 * @return the inStock
	 */
	public boolean isInStock() {
		return inStock;
	}

	/**
	 * Setter method for inStock.
	 * 
	 * @param inStock
	 *            the inStock to set
	 */
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Basic constructor.
	 * 
	 * @param name
	 *            the name of the Item.
	 */
	public Item(String name) {
		this.name = name;
		inStock = true;
	}

	public void deliverItem() {
		setInStock(true);
	}

	public void sellItem() {
		setInStock(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}
}
