package com.sirma.itt.javacourse.threads.test.task4;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task4.synchronized_threads.CounterSynchronizedThread;

/**
 * Test for {@link CounterSynchronizedThread}
 * 
 * @author Simeon Iliev
 */
public class TestThreadSync {

	private static Logger log = Logger.getLogger(TestThreadSync.class);
	private CounterSynchronizedThread threadOne;
	private CounterSynchronizedThread threadTwo;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		threadOne = new CounterSynchronizedThread();
		threadTwo = new CounterSynchronizedThread();
	}

	/**
	 * Test how long the threads have counted.
	 */
	@Test
	public void testNormalRun() {
		threadOne.setUpThread(2);
		threadTwo.setUpThread(2);
		threadOne.start();
		threadTwo.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertEquals(threadOne.getCurrentCount(), threadTwo.getCurrentCount());
	}

	/**
	 * Test thread status.
	 */
	@Test
	public void testWaiting() {
		threadOne.setUpThread(14);
		threadOne.start();
		assertEquals(Thread.State.RUNNABLE, threadOne.getState());
	}
}
