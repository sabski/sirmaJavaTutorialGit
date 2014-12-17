package com.sirma.itt.javacourse.threads.test.task2;

import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task2.twocounterthreads.StoperThread;

/**
 * @author Simeon Iliev
 */
public class TestStoperThread {

	private final Logger log = Logger.getLogger(TestStoperThread.class.getName());
	private StoperThread threadOne;
	private StoperThread threadTwo;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		threadOne = new StoperThread();
		threadTwo = new StoperThread();
	}

	/**
	 * Test if the first thread will stop the second thread.
	 */
	@Test
	public void test() {
		threadTwo.setUpThread(2);
		threadOne.setUpThread(1);

		threadOne.start();
		threadTwo.start();
		try {
			Thread.sleep(2350);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertFalse(threadTwo.isAlive());
	}

}
