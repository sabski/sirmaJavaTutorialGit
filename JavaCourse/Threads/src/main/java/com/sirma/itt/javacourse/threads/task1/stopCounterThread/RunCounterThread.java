package com.sirma.itt.javacourse.threads.task1.stopCounterThread;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author Simeon Iliev
 */
public class RunCounterThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = null;
		IOUtils.printConsoleMessage("Input max value that you want the thread to count  : ");
		CounterThread thread = new CounterThread(IOUtils.readInt());
		IOUtils.printConsoleMessage("Counter is set to : " + thread.getCount());
		IOUtils.printConsoleMessage("The thread starts counting now");
		IOUtils.printConsoleMessage("To stop the thread you must type something in the console");
		thread.start();
		str = IOUtils.readLine();
		thread.stop();
		IOUtils.printConsoleMessage("Count is " + thread.getCount());
	}

}
