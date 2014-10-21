package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

/**
 * Base product.
 * 
 * @author Simeon Iliev
 */
public abstract class AbstractProduct {

	private String name;
	private int quantity;

	/**
	 * Constructor for the product.
	 * 
	 * @param name
	 *            the type of the pro
	 */
	public AbstractProduct(String name) {
		this.setName(name);
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
	 * Getter method for quantity.
	 * 
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity.
	 * 
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
