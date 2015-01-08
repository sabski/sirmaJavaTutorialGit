package com.sirma.itt.javacourse.threads.task3.sleepingcounterthreads;

import org.apache.log4j.Logger;

/**
 * Thread class that counts to a specific value and stops all other threads of
 * this class.
 * 
 * 
 * @author Simeon Iliev
 */
public class StoperThreadWithWait extends Thread {

	private final static Logger LOGGER = Logger
			.getLogger(StoperThreadWithWait.class);

	private int currentCount = 0;
	private int count;
	private volatile boolean flag = true;

	@Override
	public void run() {
		while (flag && count > currentCount) {
			try {
				synchronized (this) {
					wait(1000);
				}
				LOGGER.info("Current count is : " + currentCount);
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
			currentCount++;
		}
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
