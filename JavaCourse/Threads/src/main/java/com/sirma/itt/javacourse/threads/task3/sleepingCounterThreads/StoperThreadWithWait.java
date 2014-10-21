package com.sirma.itt.javacourse.threads.task3.sleepingCounterThreads;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author Simeon Iliev
 */
public class StoperThreadWithWait extends Thread {

	private final Logger log = Logger.getLogger(StoperThreadWithWait.class.getName());

	private int currentCount = 0;
	private int count;
	private Thread threadToStop;

	@Override
	public void run() {
		while (isAlive() && count > currentCount) {
			try {
				synchronized (this) {
					wait(1000);
				}
				printCount(currentCount);
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

	private static synchronized void printCount(int currentCount) {
		IOUtils.printConsoleMessage("Current count is : " + currentCount);
	}
}
