package com.sirma.itt.javacourse.threads.test.task7;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task7.producerconsumer.Consumer;
import com.sirma.itt.javacourse.threads.task7.producerconsumer.Producer;
import com.sirma.itt.javacourse.threads.task7.producerconsumer.Product;

/**
 * @author Simeon Iliev
 */
public class TestProducerConsumer {

	private final Logger log = Logger.getLogger(TestProducerConsumer.class);
	private Product product;
	private Producer producer;
	private Consumer consumer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		product = new Product("Sirene", 50);
		consumer = new Consumer(product, 60, 10);
		producer = new Producer(product, 50, 10);
	}

	@Test
	public void testProductProduce() {
		producer.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertEquals(10, product.getQuantity());
	}

	@Test
	public void testOutOfStock() {
		producer.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		producer.interrupt();
		consumer.start();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertEquals(0, product.getQuantity());
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		if (consumer.isAlive()) {
			consumer.interrupt();
		}
		if (producer.isAlive()) {
			producer.interrupt();
		}
	}
}
