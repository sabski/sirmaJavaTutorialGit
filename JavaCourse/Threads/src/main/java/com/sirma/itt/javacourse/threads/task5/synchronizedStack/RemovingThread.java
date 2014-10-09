package com.sirma.itt.javacourse.threads.task5.synchronizedStack;

/**
 * @author Simeon Iliev
 */
public class RemovingThread extends Thread {

	private ObjectListSynchonized lock;

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
			lock.removeElement();
			// end work
			lock.notifyAll();

		}
	}

	/**
	 * @param lock
	 */
	public RemovingThread(ObjectListSynchonized lock) {
		this.lock = lock;
	}

	private boolean chekFlag() {
		return lock.isFlag();
	}

}
