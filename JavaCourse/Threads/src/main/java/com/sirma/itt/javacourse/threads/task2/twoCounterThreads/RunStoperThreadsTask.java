package com.sirma.itt.javacourse.threads.task2.twoCounterThreads;

/**
 * Runner class for StoperThread task.
 * 
 * @author Simeon Iliev
 */
public class RunStoperThreadsTask {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments for the main method.
	 */
	public static void main(String[] args) {
		StoperThread threadOne = new StoperThread();
		StoperThread threadTwo = new StoperThread();
		StoperThread threadThree = new StoperThread();
		StoperThread threadFour = new StoperThread();
		threadOne.setUpThread(5);
		threadTwo.setUpThread(9);
		threadThree.setUpThread(35);
		threadFour.setUpThread(6);
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start();
	}

}
