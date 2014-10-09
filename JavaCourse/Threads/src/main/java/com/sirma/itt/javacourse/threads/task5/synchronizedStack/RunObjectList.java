package com.sirma.itt.javacourse.threads.task5.synchronizedStack;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Run class for ObjectListSynchonized task.
 * 
 * @author simeon
 */
public class RunObjectList {

	private static Logger log = Logger.getLogger(RunObjectList.class.getName());

	/**
	 * Maim method for the application.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		ObjectListSynchonized list;
		IOUtils.printConsoleMessage("Input List size : ");
		list = new ObjectListSynchonized(IOUtils.readInt());
		while (true) {
			IOUtils.printConsoleMessage("Menu operations :\n 1: Insert Item \n 2: Delete Item \n 3: Print all elements \n -1: Exit program ");
			int code = IOUtils.readInt();
			switch (code) {
				case 1:
					IOUtils.printConsoleMessage("Input value");
					list.addElement(IOUtils.readLine());
					break;
				case 2:
					IOUtils.printConsoleMessage("Removing item");
					list.removeElement();
					break;
				case 3:
					list.printAllElements();
					break;
				case -1:
					System.exit(0);
					break;
				default:
					IOUtils.printConsoleMessage("Wrong menu code ");
					break;
			}
		}

	}

}
