package com.sirma.itt.javacourse.threads.task7.producer_consumer;

import org.apache.log4j.Logger;

/**
 * A consumer of a product in a warehouse. The thread will try to buy at a regular interval if it can
 * not buy within the interval it is waiting and when it is notified then the time continues.
 * 
 * @author Simeon Iliev
 */
public class Consumer extends Thread {

	private static Logger log = Logger.getLogger(Consumer.class);
	
	private static int threadCount = 0;
	private final Product product;
	private final long timeToBye;
	private final int demand;
	private final int threadNumber;

	/**
	 * Constructor for Consumer thread.
	 * 
	 * @param product
	 *            the product this thread is buying.
	 * @param timeToBye
	 *            the interval of time this thread will want to buy the product.
	 * @param demand
	 *            the demand for the product.
	 */
	public Consumer(Product product, long timeToBye, int demand) {
		this.product = product;
		this.timeToBye = timeToBye;
		this.demand = demand;
		threadNumber = threadCount++;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(timeToBye);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			log.info(Consumer.class.getName() + " : " + threadNumber);
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
