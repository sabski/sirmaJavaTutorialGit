package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import org.apache.log4j.Logger;

/**
 * Product class that represent a product that will be delivered and sold.
 * 
 * @author Simeon Iliev
 */
public class Product extends AbstractProduct {

	private final Logger log = Logger.getLogger(Product.class.getName());

	private final boolean shoulProduce = true;
	private final boolean canBye = false;
	private int maxQuantity;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            Type of the product.
	 */
	public Product(String type) {
		super(type);
	}

	/**
	 * Bye method for product.
	 * 
	 * @param quantity
	 *            Of the product that is to be bought.
	 */
	public synchronized void deliverProduct(int quantity) {
		setQuantity(quantity + getQuantity());
		log.info("New product value is " + getQuantity());
	}

	/**
	 * Sells a specific quality of the product.
	 * 
	 * @param quantity
	 *            Of the product to be sold.
	 */
	public synchronized void sellProduct(int quantity) {
		setQuantity(getQuantity() - quantity);
		log.info("New product value is " + getQuantity());
	}
}
