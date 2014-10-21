package com.sirma.itt.javacourse.threads.test.task3;

import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task2.twoCounterThreads.StoperThread;
import com.sirma.itt.javacourse.threads.task3.sleepingCounterThreads.StoperThreadWithWait;

/**
 * Test for waiting threads.
 * 
 * @author Simeon Iliev
 */
public class TestNotifySleep {
	private final Logger log = Logger.getLogger(TestNotifySleep.class);
	private StoperThread threadOne;
	private StoperThreadWithWait threadTwo;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		threadOne = new StoperThread();
		threadTwo = new StoperThreadWithWait();
		threadOne.setUpThread(1, threadTwo);
		threadTwo.setUpThread(2, threadOne);
	}

	/**
	 * Test if the first thread will stop the second thread.
	 */
	@Test
	public void testStopping() {
		threadOne.start();
		threadTwo.start();
		try {
			Thread.sleep(1350);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertFalse(threadTwo.isAlive());
	}

}
