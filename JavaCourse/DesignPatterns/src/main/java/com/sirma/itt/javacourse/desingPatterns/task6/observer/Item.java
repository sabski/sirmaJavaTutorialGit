package com.sirma.itt.javacourse.desingPatterns.task6.observer;

/**
 * Item class that stores information about an item.
 * 
 * @author Simeon Iliev
 */
public class Item {

	private String name;

	/**
	 * @param name
	 *            the name of the product
	 */
	public Item(String name) {
		this.name = name;
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

}
