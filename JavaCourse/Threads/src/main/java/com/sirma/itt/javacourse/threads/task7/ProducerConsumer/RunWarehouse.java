package com.sirma.itt.javacourse.threads.task7.ProducerConsumer;

/**
 * Runner class for warehouse producer and consumer.
 * 
 * @author Simeon Iliev
 */
public class RunWarehouse {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments for the main method
	 */
	public static void main(String[] args) {
		// TODO Be great
		Product product = new Product("Sirene",100);
		Producer producer = new Producer(product, 500, 2);
		Consumer consumer = new Consumer(product, 450, 1);
		Producer producer1 = new Producer(product, 500, 7);
		Consumer consumer1 = new Consumer(product, 400, 5);
		producer.start();
		consumer.start();
		producer1.start();
		consumer1.start();
	}

}
