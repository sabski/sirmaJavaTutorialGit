package com.sirma.itt.javacourse.threads.test.task2;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task2.twoCounterThreads.StoperThread;

/**
 * @author Simeon Iliev
 */
public class TestStoperThread {

	private Logger log = Logger.getLogger(TestStoperThread.class.getName());
	private StoperThread threadOne;
	private StoperThread threadTwo = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		threadOne = new StoperThread();
		threadTwo = new StoperThread();
	}

	@Test
	public void test() {
		threadTwo.setUpThread(6, threadOne);
		threadOne.setUpThread(5, threadTwo);

		threadOne.start();
		threadTwo.start();
		try {
			Thread.sleep(5150);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		assertFalse(threadTwo.isAlive());
	}

}
