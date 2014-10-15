package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;


/**
 * @author Simeon Iliev
 */
public abstract class AbstractProduct {

	private String type;
	private int quantity;

	/**
	 * @param type
	 */
	public AbstractProduct(String type) {
		this.setType(type);
	}

	/**
	 * Getter method for type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter method for type.
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
