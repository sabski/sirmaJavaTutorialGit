package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import org.apache.log4j.Logger;

/**
 * Thread class that produces a resource and supplies it to a warhouse.
 * 
 * @author Simeon Iliev
 */
public class Producer extends Thread {

	private static Logger log = Logger.getLogger(Producer.class);
	private final Product product;
	private final long productionTime;

	/**
	 * @param product
	 * @param productionTime
	 */
	public Producer(Product product, long productionTime) {
		this.product = product;
		this.productionTime = productionTime;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(productionTime);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			product.deliverProduct(2);
		}
	}

}
