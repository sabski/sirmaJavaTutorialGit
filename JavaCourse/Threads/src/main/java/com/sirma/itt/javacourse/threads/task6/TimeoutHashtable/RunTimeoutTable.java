package com.sirma.itt.javacourse.threads.task6.TimeoutHashtable;

import com.sirma.itt.javacourse.InputUtils;

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
		InputUtils.printConsoleMessage("Input timeout for table in seconds");
		long timeout = InputUtils.readInt() * 1000;
		TimeoutHashtable table = new TimeoutHashtable(timeout);
		String tempKey;
		String tempValue;
		while (true) {
			InputUtils.printConsoleMessage("Menu :\n 1. Add key and value\n 2. Get value with key\n 3. Remove value with key\n 4. Print table.\n -1. Exit");
			int key = InputUtils.readInt();
			switch (key) {
				case 1:
					InputUtils.printConsoleMessage("Enter key value");
					tempKey = InputUtils.readLine();
					InputUtils.printConsoleMessage("Enter value");
					tempValue = InputUtils.readLine();
					table.put(tempKey, tempValue);
					break;
				case 2:
					InputUtils.printConsoleMessage("Enter key value");
					tempKey = InputUtils.readLine();
					table.get(tempKey);
					break;
				case 3:
					InputUtils.printConsoleMessage("Enter key value");
					tempKey = InputUtils.readLine();
					table.remove(tempKey);
					break;
				case 4:
					InputUtils.printConsoleMessage("Table contents : " + table);
					break;
				case -1:
					System.exit(0);
					break;
				default:
					InputUtils.printConsoleMessage("Invalid code operation");
					break;
			}
		}
	}
}
