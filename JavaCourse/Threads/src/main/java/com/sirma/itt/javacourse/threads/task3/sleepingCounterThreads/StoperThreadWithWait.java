package com.sirma.itt.javacourse.threads.task3.sleepingCounterThreads;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class StoperThreadWithWait extends Thread {

	private final static Logger log = Logger.getLogger(StoperThreadWithWait.class.getName());

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
				log.info("Current count is : " + currentCount);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
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
