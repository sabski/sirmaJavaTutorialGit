package com.sirma.itt.javacourse.threads.task2.twoCounterThreads;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;

/**
 * A Thread class that count to a specific value and stops other thread.
 * 
 * @author Simeon Iliev
 */
public class StoperThread extends Thread {

	private final Logger log = Logger.getLogger(StoperThread.class.getName());

	private int currentCount = 0;
	private int count;
	private Thread threadToStop;


	@Override
	public void run() {
		while (isAlive() && count > currentCount) {
			try {
				Thread.sleep(1000);
				InputUtils.printConsoleMessage("Current count is : " + currentCount);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			currentCount++;
		}
		if (threadToStop.isAlive() && threadToStop != null) {
			threadToStop.stop();
		}
	}

	/**
	 * Set up method for thread.
	 * 
	 * @param count
	 *            the count for the tread to count to.
	 * @param threadToStop
	 *            the other thread to stop counting.
	 */
	public void setUpThread(int count, Thread threadToStop) {
		this.count = count;
		this.threadToStop = threadToStop;
	}

}
