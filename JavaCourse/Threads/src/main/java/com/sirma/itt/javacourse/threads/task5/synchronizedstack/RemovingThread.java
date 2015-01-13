package com.sirma.itt.javacourse.threads.task5.synchronizedstack;

import org.apache.log4j.Logger;

/**
 * Thread class that removes elements from {@link ObjectListSynchonized} object.
 * 
 * @author Simeon Iliev
 */
public class RemovingThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(RemovingThread.class);
	private ObjectListSynchonized list;

	@Override
	public void run() {
		while (!chekFlag()) {
			synchronized (list) {
				list.notify();
				try {
					list.wait();
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
		// Remove element from the list
		LOGGER.info("The element was removed " + list.removeElement());
	}

	/**
	 * Constructor with {@link ObjectListSynchonized} that is used as a lock.
	 * 
	 * @param lock
	 *            the object list that we are going to add and use as a lock
	 *            object.
	 */
	public RemovingThread(ObjectListSynchonized lock) {
		this.list = lock;
	}

	/**
	 * Checks the flag of the current object.
	 * 
	 * @return the lock status.
	 */
	private boolean chekFlag() {
		return list.isRemoveFlag();
	}

}
