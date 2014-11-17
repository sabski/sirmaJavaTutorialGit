package com.sirma.itt.javacourse.threads.task1.stopCounterThread;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Runner class for Counter Thread.
 * 
 * @author Simeon Iliev
 */
public class RunCounterThread {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments for the main method.
	 */
	public static void main(String[] args) {
		InputUtils.printConsoleMessage("Input max value that you want the thread to count  : ");
		CounterThread thread = new CounterThread(InputUtils.readInt());
		InputUtils.printConsoleMessage("Counter is set to : " + thread.getCount());
		InputUtils.printConsoleMessage("The thread starts counting now");
		InputUtils.printConsoleMessage("To stop the thread you must type something in the console");
		thread.start();
		InputUtils.readLine();
		thread.stopThread();
		InputUtils.printConsoleMessage("Count is " + thread.getCount());
	}

}
