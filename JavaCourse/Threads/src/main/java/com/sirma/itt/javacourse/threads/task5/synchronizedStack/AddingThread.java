package com.sirma.itt.javacourse.threads.task5.synchronizedStack;

/**
 * @author Simeon Iliev
 */
public class AddingThread extends Thread {

	private ObjectListSynchonized lock;
	private Object objectToAdd;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		synchronized (lock) {
			while (!chekFlag()) {
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// work here
			lock.addElement(objectToAdd);
			// end work
			lock.notifyAll();

		}
	}

	public void setUpThread(Object objectToAdd) {
		this.objectToAdd = objectToAdd;
	}

	/**
	 * @param lock
	 */
	public AddingThread(ObjectListSynchonized lock) {
		this.lock = lock;
	}

	private boolean chekFlag() {
		return lock.isFlag();
	}
}
