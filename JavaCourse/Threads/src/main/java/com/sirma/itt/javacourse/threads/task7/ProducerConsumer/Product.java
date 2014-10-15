package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class Product extends AbstractProduct {

	private final Logger log = Logger.getLogger(Product.class.getName());

	private final boolean shoulProduce = true;
	private final boolean canBye = false;
	private int maxQuantity;

	public Product(String type) {
		super(type);
	}

	public void byeProduct() {
		if (getQuantity() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}
		
	}
}
