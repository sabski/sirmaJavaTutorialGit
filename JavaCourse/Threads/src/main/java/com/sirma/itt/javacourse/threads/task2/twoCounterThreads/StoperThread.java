package com.sirma.itt.javacourse.threads.task2.twoCounterThreads;

import org.apache.log4j.Logger;

/**
 * A Thread class that count to a specific value and stops other thread.
 * 
 * @author Simeon Iliev
 */
public class StoperThread extends Thread {

	private final Logger log = Logger.getLogger(StoperThread.class.getName());

	private int currentCount = 0;
	private int count;
	private volatile static boolean flag = true;

	@Override
	public void run() {
		while (flag && count > currentCount) {
			try {
				Thread.sleep(1000);
				log.info("Current count is : " + currentCount);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
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
