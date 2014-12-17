package com.sirma.itt.javacourse.threads.task6.timeouthashtable;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Thread that timeouts an object if it is not used.
 * 
 * @author Simeon Iliev
 */
public class TimingThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(TimingThread.class);
	private final long timeout;
	private long timeToLive;
	private final String key;
	private final TimeoutHashtable table;

	/**
	 * Constructor for {@link TimingThread}.
	 * 
	 * @param timeout
	 *            the timeout of the thread.
	 * @param key
	 *            the key to the object in the table.
	 * @param table
	 *            the table that contains the object we are intersted in.
	 */
	public TimingThread(long timeout, String key, TimeoutHashtable table) {
		this.timeout = timeout;
		this.key = key;
		this.table = table;
		updateTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (timeToLive > new Date().getTime()) {
			LOGGER.info("Thread is waiting");
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		LOGGER.info("Removing object");
		table.remove(key);
		table.removeThread(this);
	}

	private long calculateTimeToLive(long timeout) {
		return timeout + new Date().getTime();
	}

	public void updateTime() {
		timeToLive = calculateTimeToLive(timeout);
	}

	/**
	 * Getter method for key.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

}
