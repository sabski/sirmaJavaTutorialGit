package com.sirma.itt.javacourse.threads.task7.producerconsumer;

import org.apache.log4j.Logger;

/**
 * Thread class that produces a resource and supplies it to a warehouse. The thread produces a
 * specified quantity of the product at regular intervals if the product has reached maximum supply
 * it waits for some of it to be consumed.
 * 
 * @author Simeon Iliev
 */
public class Producer extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Producer.class);

	private static int numThreads = 0;
	private final Product product;
	private final long productionTime;
	private final int supply;
	private final int threadNumber;

	/**
	 * Constructor for the thread.
	 * 
	 * @param product
	 *            the product this thread produces.
	 * @param productionTime
	 *            the time it takes the thread to produce the supply.
	 * @param supply
	 *            the supply that this thread can provide.
	 */
	public Producer(Product product, long productionTime, int supply) {
		this.product = product;
		this.productionTime = productionTime;
		this.supply = supply;
		threadNumber = numThreads++;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(productionTime);
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
			LOGGER.info(Producer.class.getName() + " : " + threadNumber);
			product.deliverProduct(supply);
			synchronized (product) {
				product.notify();
				try {
					product.wait();
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}

}
