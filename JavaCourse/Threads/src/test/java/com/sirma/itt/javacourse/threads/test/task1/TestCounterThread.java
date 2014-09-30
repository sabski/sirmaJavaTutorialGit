package com.sirma.itt.javacourse.threads.test.task1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task1.stopCounterThread.CounterThread;

/**
 * @author Simeon Iliev
 */
public class TestCounterThread {

	private CounterThread thread;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		thread = new CounterThread(5);
	}

	@Test
	public void testWhenThreadIsStoped() {

		thread.start();
		try {
			Thread.sleep(4005);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.stop();
		assertEquals(4, thread.getCount());
	}

	@Test
	public void testWhenThreadIsMaxedOut() {

		thread.start();
		try {
			Thread.sleep(6005);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.stop();
		assertEquals(5, thread.getCount());
	}

}
