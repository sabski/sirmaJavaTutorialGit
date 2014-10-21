package com.sirma.itt.javacourse.threads.task3.sleepingCounterThreads;

import com.sirma.itt.javacourse.threads.task2.twoCounterThreads.StoperThread;

/**
 * Runner class to compare sleep and wait.
 * 
 * @author Simeon Iliev
 */
public class RunThread {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		StoperThread threadOne = new StoperThread();
		StoperThreadWithWait threadTwo = new StoperThreadWithWait();

		threadOne.setUpThread(15, threadTwo);
		threadTwo.setUpThread(10, threadOne);
		threadOne.start();
		threadTwo.start();
	}

}
