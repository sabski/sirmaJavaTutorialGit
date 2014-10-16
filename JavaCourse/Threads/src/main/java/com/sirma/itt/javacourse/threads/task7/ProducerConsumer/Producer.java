package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

import org.apache.log4j.Logger;

/**
 * Thread class that produces a resource and supplies it to a warehouse.
 * 
 * @author Simeon Iliev
 */
public class Producer extends Thread {

	private static Logger log = Logger.getLogger(Producer.class);
	private final Product product;
	private final long productionTime;
	private final int suply;

	/**
	 * @param product
	 * @param productionTime
	 * @param suply
	 */
	public Producer(Product product, long productionTime, int suply) {
		this.product = product;
		this.productionTime = productionTime;
		this.suply = suply;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(productionTime);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			product.deliverProduct(suply);
		}
	}

}
