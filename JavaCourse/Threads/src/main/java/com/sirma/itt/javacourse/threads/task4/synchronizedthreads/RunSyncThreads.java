package com.sirma.itt.javacourse.threads.task4.synchronizedthreads;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Runner class for synchronized counting.
 * 
 * @author Simeon Iliev
 */
public class RunSyncThreads {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		CounterSynchronizedThread threadOne = new CounterSynchronizedThread();
		CounterSynchronizedThread threadTwo = new CounterSynchronizedThread();
		InputUtils.printConsoleMessage("Input number for the threads to count to.");
		int temp = InputUtils.readInt();
		threadOne.setUpThread(temp);
		threadTwo.setUpThread(temp);
		threadOne.start();
		threadTwo.start();
	}

}
