package com.sirma.itt.javacourse.inputoutput.task6.serialization;

import java.io.IOException;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for running serialization example we create a new UserDefinedObject and save it to a file
 * and then we read the object and save it into a file then we read the file and retrieve the object
 * from it.
 * 
 * @author simeon
 */
public class RunSerializathionObjects {

	/**
	 * Main method for the application
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = null;
		int myNumber;
		String say;
		Utils.printConsoleMessage("Input number and String to say something");
		Utils.printConsoleMessage("Input my number ");
		myNumber = Utils.readInt();
		Utils.printConsoleMessage("Input say something for the object");
		say = Utils.readLine();
		UserDefinedObject object = new UserDefinedObject(myNumber, say);
		Utils.printConsoleMessage("Input path to file to save the object");
		path = Utils.readLine();
		object.saveObject(path, object);
		UserDefinedObject object2 = null;
		try {
			object2 = object.getObject(path);
			Utils.printConsoleMessage(object2.getSaySomething());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
