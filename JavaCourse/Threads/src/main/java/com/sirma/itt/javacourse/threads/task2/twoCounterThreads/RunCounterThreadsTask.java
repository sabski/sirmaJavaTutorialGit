package com.sirma.itt.javacourse.threads.task2.twoCounterThreads;

/**
 * @author Simeon Iliev
 */
public class RunCounterThreadsTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StoperThread threadOne = new StoperThread();
		StoperThread threadTwo = new StoperThread();
		StoperThread threadThree = new StoperThread();
		StoperThread threadFour = new StoperThread();
		threadOne.setUpThread(5, threadTwo);
		threadTwo.setUpThread(9, threadOne);
		threadThree.setUpThread(35, threadFour);
		threadFour.setUpThread(6, threadThree);
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start();
	}

}
