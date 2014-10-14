package com.sirma.itt.javacourse.threads.task6.TimeoutHashtable;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Thread that timeouts an object if it is not used.
 * 
 * @author Simeon Iliev
 */
public class TimingThread extends Thread {

	private final Logger log = Logger.getLogger(TimingThread.class);
	private final long timeout;
	private long timeToLive;

	/**
	 * @param timeout
	 */
	public TimingThread(long timeout) {
		this.timeout = timeout;
		updateTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private long calculateTimeToLive(long timeout) {
		return timeout + new Date().getTime();
	}

	public void updateTime() {
		timeToLive = calculateTimeToLive(timeout);
	}

}
