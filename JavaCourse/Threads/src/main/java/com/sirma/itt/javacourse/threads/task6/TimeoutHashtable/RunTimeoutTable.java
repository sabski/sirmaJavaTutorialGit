package com.sirma.itt.javacourse.threads.task6.TimeoutHashtable;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Runner class.
 * 
 * @author Simeon Iliev
 */
public class RunTimeoutTable {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments for the main method.
	 */
	public static void main(String[] args) {
		IOUtils.printConsoleMessage("Input timeout for table in seconds");
		long timeout = IOUtils.readInt() * 1000;
		TimeoutHashtable table = new TimeoutHashtable(timeout);
		String tempKey;
		String tempValue;
		while (true) {
			IOUtils.printConsoleMessage("Menu :\n 1. Add key and value\n 2. Get value with key\n 3. Remove value with key\n 4. Print table.\n -1. Exit");
			int key = IOUtils.readInt();
			switch (key) {
				case 1:
					IOUtils.printConsoleMessage("Enter key value");
					tempKey = IOUtils.readLine();
					IOUtils.printConsoleMessage("Enter value");
					tempValue = IOUtils.readLine();
					table.put(tempKey, tempValue);
					break;
				case 2:
					IOUtils.printConsoleMessage("Enter key value");
					tempKey = IOUtils.readLine();
					table.get(tempKey);
					break;
				case 3:
					IOUtils.printConsoleMessage("Enter key value");
					tempKey = IOUtils.readLine();
					table.remove(tempKey);
					break;
				case 4:
					IOUtils.printConsoleMessage("Table contents : " + table);
					break;
				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("Invalid code operation");
					break;
			}
		}
	}
}
