package com.sirma.itt.javacourse.threads.task1.stopCounterThread;

import org.apache.log4j.Logger;

/**
 * Class that counts the time from the start of the Thread to a concole command or a specific value.
 * 
 * @author Simeon Iliev
 */
public class CounterThread extends Thread {

	private Logger log = Logger.getLogger(CounterThread.class.getName());
	private int count = 0;
	private int maxCount;

	/**
	 * Constructor .
	 * @param maxCount the maximum number for the thread to count to.
	 */
	public CounterThread(int maxCount) {
		this.maxCount = maxCount;
	}

	@Override
	public void run() {
		while (isAlive() && maxCount > count) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			count++;
		}
	}

	/**
	 * @return the current count.
	 */
	public int getCount() {
		return count;
	}

}
