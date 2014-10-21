package com.sirma.itt.javacourse.inputoutput.task6.serialization;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running serialization example we create a new {@link UserDefinedObject} and save it to
 * a file and then we read the object and save it into a file then we read the file and retrieve the
 * object from it.
 * 
 * @author Simeon Iliev
 */
public class RunSerializathionObjects {

	private static Logger log = Logger.getLogger(RunSerializathionObjects.class.getName());

	/**
	 * Main method for the application
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {

		String path = null;
		int myNumber;
		String say;
		IOUtils.printConsoleMessage("Input number and String to say something");
		IOUtils.printConsoleMessage("Input my number ");
		myNumber = IOUtils.readInt();
		IOUtils.printConsoleMessage("Input say something for the object");
		say = IOUtils.readLine();
		UserDefinedObject object = new UserDefinedObject(myNumber, say);
		IOUtils.printConsoleMessage("Input path to file to save the object");
		path = IOUtils.readLine();
		object.saveObject("target/" + path, object);
		UserDefinedObject object2 = null;
		try {
			object2 = object.getObject("target/" + path);
			IOUtils.printConsoleMessage("The object read says " + object2.getSaySomething());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

}
