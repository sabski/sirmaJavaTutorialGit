package com.sirma.itt.javacourse.threads.test.task4;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task4.synchronizedThreads.CounterSynchronizrdThread;

/**
 * Test for {@link CounterSynchronizrdThread}
 * 
 * @author Simeon Iliev
 */
public class TestThreadSync {

	private static Logger log = Logger.getLogger(TestThreadSync.class);
	private CounterSynchronizrdThread threadOne;
	private CounterSynchronizrdThread threadTwo;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		threadOne = new CounterSynchronizrdThread();
		threadTwo = new CounterSynchronizrdThread();
	}

	/**
	 * Test how long the threads hova counted.
	 */
	@Test
	public void testNormalRun() {
		threadOne.setUpThread(5);
		threadTwo.setUpThread(5);
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
		threadOne.setUpThread(4);
		threadOne.start();
		assertEquals(Thread.State.RUNNABLE, threadOne.getState());
	}
}
