package com.sirma.itt.javacourse.threads.test.task1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task1.stopCounterThread.CounterThread;

/**
 * Test class for {@link CounterThread}.
 * 
 * @author Simeon Iliev
 */
public class TestCounterThread {

	private CounterThread thread;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		thread = new CounterThread(5);
	}

	/**
	 * Test how far the count has gone.
	 */
	@Test
	public void testWhenThreadIsStoped() {

		thread.start();
		try {
			Thread.sleep(4005);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(4, thread.getCount());
	}

	/**
	 * Test if the thread finnishes counting properly.
	 */
	@Test
	public void testWhenThreadIsMaxedOut() {

		thread.start();
		try {
			Thread.sleep(6005);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(5, thread.getCount());
	}

}
