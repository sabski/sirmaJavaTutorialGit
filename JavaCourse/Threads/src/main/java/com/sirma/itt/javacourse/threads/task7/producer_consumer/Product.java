package com.sirma.itt.javacourse.threads.task7.producer_consumer;

import org.apache.log4j.Logger;

/**
 * Product class that represent a product that will be delivered and sold.
 * 
 * @author Simeon Iliev
 */
public class Product extends AbstractProduct {

	private final static Logger log = Logger.getLogger(Product.class.getName());
	private final int maxQuantity;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            Type of the product.
	 * @param maxQuantity
	 *            The maximum quantity of the product.
	 */
	public Product(String type, int maxQuantity) {
		super(type);
		this.maxQuantity = maxQuantity;
		setQuantity(0);
	}

	/**
	 * Buy method for product.
	 * 
	 * @param quantity
	 *            Of the product that is to be bought.
	 */
	public synchronized void deliverProduct(int quantity) {
		while (!shouldProduceQuantity(quantity)) {
			this.notify();
			try {
				this.wait();
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}
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
		while (!canBuy(quantity)) {
			this.notify();
			try {
				this.wait();
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}
		setQuantity(getQuantity() - quantity);
		log.info("New product value is " + getQuantity());
	}

	/**
	 * Checks if more quantity of the product should be produced.
	 * 
	 * @param quantity
	 *            The quantity that is to be produced.
	 * @return true if the produced quantity does not go over the limit.
	 */
	public boolean shouldProduceQuantity(int quantity) {
		return (getQuantity() + quantity) <= maxQuantity;
	}

	/**
	 * Checks if there is enough quantity for the user to buy.
	 * 
	 * @param quantity
	 *            The quantity that the user want to buy.
	 * @return true if the quantity does not go bellow 0.
	 */
	public boolean canBuy(int quantity) {
		return (getQuantity() - quantity) >= 0;
	}
}
