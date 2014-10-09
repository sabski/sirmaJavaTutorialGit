package com.sirma.itt.javacourse.threads.task4.synchronizedThreads;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class for synconized counting.
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
		CounterSynchronizrdThread threadOne = new CounterSynchronizrdThread();
		CounterSynchronizrdThread threadTwo = new CounterSynchronizrdThread();
		IOUtils.printConsoleMessage("Input number for the threads to count to.");
		int temp = IOUtils.readInt();
		threadOne.setUpThread(temp);
		threadTwo.setUpThread(temp);
		threadOne.start();
		threadTwo.start();
	}

}
