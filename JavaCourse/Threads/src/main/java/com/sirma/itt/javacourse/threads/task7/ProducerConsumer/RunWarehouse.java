package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

/**
 * Runner class for warehouse producer and consumer.
 * 
 * @author Simeon Iliev
 */
public class RunWarehouse {

	/**
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {
		// TODO Be great
		Product product = new Product("Sirene");
		Producer producer = new Producer(product, 500);
		Consumer consumer = new Consumer(product, 450);
		Producer producer1 = new Producer(product, 500);
		Consumer consumer1 = new Consumer(product, 400);
		producer.start();
		consumer.start();
		producer1.start();
		consumer1.start();
	}

}
