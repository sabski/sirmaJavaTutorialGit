package com.sirma.itt.javacourse.threads.task4.synchronized_threads;

import org.apache.log4j.Logger;

/**
 * A Thread class that count to a specific value and stops other thread.
 * 
 * @author Simeon Iliev
 */
public class CounterSynchronizedThread extends Thread {

	private static final Logger log = Logger.getLogger(CounterSynchronizedThread.class.getName());
	private static int threadNumber = 0;
	private static final Lock lock = new Lock();

	private int currentCount = 0;
	private int count;
	private int currentNumber;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (count > currentCount) {
			currentCount++;
			lock.printCount(currentCount, currentNumber);
		}
		// Notifies waiting threads and allows the thread to stop normally.
		synchronized (lock) {
			lock.notify();
		}
	}

	/**
	 * Getter method for currentCount.
	 * 
	 * @return the currentCount
	 */
	public int getCurrentCount() {
		return currentCount;
	}

	/**
	 * Set up method for thread.
	 * 
	 * @param count
	 *            the count for the tread to count to.
	 * @param threadToStop
	 *            the other thread to stop counting.
	 */
	public void setUpThread(int count) {
		this.count = count;
		currentNumber = threadNumber++;
	}

	/**
	 * Class used for locking thread instances and printing out console messages.
	 * 
	 * @author Simeon Iliev
	 */
	static class Lock {

		private static final Logger log = Logger.getLogger(CounterSynchronizedThread.class
				.getName());

		/**
		 * Synchronized method for printing the countdown of a thread.
		 * 
		 * @param currentCount
		 *            the number the thread has counted to.
		 * @param currentNumber
		 *            the number of the thread.
		 */
		public void printCount(int currentCount, int currentNumber) {
			synchronized (this) {
				log.info("Thread : " + currentNumber
						+ "  Current count is : " + currentCount);
				this.notify();
				try {
					this.wait(500);
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
}