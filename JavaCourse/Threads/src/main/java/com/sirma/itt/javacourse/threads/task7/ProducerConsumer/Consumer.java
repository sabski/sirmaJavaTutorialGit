package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import org.apache.log4j.Logger;

/**
 * A consumer of a product in a warehouse.
 * 
 * @author Simeon Iliev
 */
public class Consumer extends Thread {

	private static Logger log = Logger.getLogger(Consumer.class);
	private final Product product;
	private final long timeToBye;
	private final int demand;

	/**
	 * @param product
	 * @param timeToBye
	 */
	public Consumer(Product product, long timeToBye, int demand) {
		this.product = product;
		this.timeToBye = timeToBye;
		this.demand = demand;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(timeToBye);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			product.sellProduct(demand);
			synchronized (product) {
				product.notify();
				try {
					product.wait();
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}
			}

		}

	}

}
