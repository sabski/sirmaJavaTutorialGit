package com.sirma.itt.javacourse.threads.task5.synchronizedstack;

import org.apache.log4j.Logger;

/**
 * Thread class that adds elements to a {@link ObjectListSynchonized} object.
 * 
 * @author Simeon Iliev
 */
public class AddingThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(AddingThread.class);
	private Object objectToAdd;
	private ObjectListSynchonized list;

	/**
	 * {@inheritDoc}
	 */
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
		// Add the element to the list...
		LOGGER.info("The element was added " + list.addElement(objectToAdd));
	}

	/**
	 * Set up thread method.
	 * 
	 * @param objectToAdd
	 *            the object that is t obe added by this thread.
	 */
	public void setUpThread(Object objectToAdd) {
		this.objectToAdd = objectToAdd;
	}

	/**
	 * Constructor with {@link ObjectListSynchonized} that is used as a lock.
	 * 
	 * @param lock
	 *            the object list that we are going to add and use as a lock object.
	 */
	public AddingThread(ObjectListSynchonized lock) {
		this.list = lock;
	}

	/**
	 * Cheks the flag of the lock object.
	 * 
	 * @return the flag status.
	 */
	private boolean chekFlag() {
		return list.isAddFlag();
	}
}
