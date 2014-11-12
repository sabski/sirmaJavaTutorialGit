package com.sirma.itt.javacourse.threads.task1.stopCounterThread;

import com.sirma.itt.javacourse.InputUtils;

/**
 * @author Simeon Iliev
 */
public class RunCounterThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = null;
		InputUtils.printConsoleMessage("Input max value that you want the thread to count  : ");
		CounterThread thread = new CounterThread(InputUtils.readInt());
		InputUtils.printConsoleMessage("Counter is set to : " + thread.getCount());
		InputUtils.printConsoleMessage("The thread starts counting now");
		InputUtils.printConsoleMessage("To stop the thread you must type something in the console");
		thread.start();
		str = InputUtils.readLine();
		thread.stop();
		InputUtils.printConsoleMessage("Count is " + thread.getCount());
	}

}
