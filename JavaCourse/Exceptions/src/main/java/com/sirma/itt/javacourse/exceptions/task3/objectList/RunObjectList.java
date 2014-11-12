package com.sirma.itt.javacourse.exceptions.task3.objectList;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Run class for ObjectList task.
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

		ObjectList list;
		InputUtils.printConsoleMessage("Input List size : ");
		list = new ObjectList(InputUtils.readInt());
		while (true) {
			InputUtils.printConsoleMessage("Menu operations :\n 1: Insert Item \n 2: Delete Item \n 3: Print all elements \n -1: Exit program ");
			int code = InputUtils.readInt();
			switch (code) {
				case 1:
					try {
						InputUtils.printConsoleMessage("Input value");
						list.addElement(InputUtils.readLine());
					} catch (OverFlodException e) {
						log.error("Too much elements in the array.", e);
					}
					break;
				case 2:
					try {
						InputUtils.printConsoleMessage("Removing item");
						list.removeElement();
					} catch (NegativeIndexException e) {
						log.error("Negative Index.", e);
					}
					break;
				case 3:
					list.printAllElements();
					break;
				case -1:
					System.exit(0);
					break;
				default:
					InputUtils.printConsoleMessage("Wrong menu code ");
					break;
			}
		}

	}

}
