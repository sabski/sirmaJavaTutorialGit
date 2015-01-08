package com.sirma.itt.javacourse.threads.task2.twocounterthreads;

import org.apache.log4j.Logger;

/**
 * A Thread class that count to a specific value and stops other thread of this
 * class.
 * 
 * @author Simeon Iliev
 */
public class StoperThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(StoperThread.class.getName());

	private int currentCount = 0;
	private int count;
	private volatile static boolean flag = true;

	@Override
	public void run() {
		while (flag && count > currentCount) {
			try {
				Thread.sleep(1000);
				LOGGER.info("Current count is : " + currentCount);
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
			currentCount++;
		}
		flag = false;
	}

	/**
	 * Set up method for thread.
	 * 
	 * @param count
	 *            the count for the tread to count to.
	 */
	public void setUpThread(int count) {
		this.count = count;
	}

	/**
	 * Reset the flag value so that thread may be executed.
	 */
	public void resetFlag() {
		flag = true;
	}

}
