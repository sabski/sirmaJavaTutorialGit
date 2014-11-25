package com.sirma.itt.javacourse.threads.task3.sleeping_counter_threads;

import com.sirma.itt.javacourse.threads.task2.two_counter_threads.StoperThread;

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

		threadOne.setUpThread(15);
		threadTwo.setUpThread(10);
		threadOne.start();
		threadTwo.start();
	}

}
