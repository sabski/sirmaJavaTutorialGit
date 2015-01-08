package com.sirma.itt.javacourse.threads.task1.stopcounterthread;

import org.apache.log4j.Logger;

/**
 * Class that counts the time from the start of the Thread to a console command or a specific value.
 * 
 * @author Simeon Iliev
 */
public class CounterThread extends Thread {

	private final Logger log = Logger.getLogger(CounterThread.class.getName());
	private int count = 0;
	private final int maxCount;
	private volatile boolean flag = true;

	/**
	 * Constructor .
	 * 
	 * @param maxCount
	 *            the maximum number for the thread to count to.
	 */
	public CounterThread(int maxCount) {
		this.maxCount = maxCount;
	}

	@Override
	public void run() {
		while (flag && maxCount > count) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			count++;
		}
	}

	/**
	 * Gets the number the thread has counted to.
	 * @return the current count.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Method to stop the execution of the current thread.
	 */
	public void stopThread() {
		flag = false;
	}

}
