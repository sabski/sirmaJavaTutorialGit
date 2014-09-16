package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running reflection example.
 * 
 * @author simeon
 */
public class RunReflectionSample {

	private static Logger log = Logger.getLogger(RunReflectionSample.class.getName());

	/**
	 * Main method for the program.
	 * 
	 * @param args
	 *            the arguments for the main method.
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws IllegalAccessException, SecurityException,
			NoSuchFieldException {

		ReflectionClass reflect = new ReflectionClass();

		IOUtils.printConsoleMessage("Set String value for the reflection object");
		reflect.setStringValue(IOUtils.readLine());
		IOUtils.printConsoleMessage("Set integer value for the reflection object");
		reflect.setIntValue(IOUtils.readInt());
		IOUtils.printConsoleMessage("Set float value for the reflection object");
		reflect.setFloatValue(IOUtils.readFlaot());
		IOUtils.printConsoleMessage("Set boolean value for the reflection object 1 - false 0 - true");
		int value = Integer.parseInt(IOUtils.readValidatedLine("[0-1]{1}"));
		if (value == 0) {
			reflect.setBooleanValue(true);
		} else {
			reflect.setBooleanValue(false);
		}
		Reflector reflector = new Reflector();
		try {
			reflector.reflect(reflect);
		} catch (IllegalArgumentException e) {
			log.error(e);
		}
	}
}
