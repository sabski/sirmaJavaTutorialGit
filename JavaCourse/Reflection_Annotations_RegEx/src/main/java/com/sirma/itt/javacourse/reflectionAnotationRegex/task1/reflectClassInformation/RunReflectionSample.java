package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class for running reflection example.
 * 
 * @author Simeon Iliev
 */
public class RunReflectionSample {

	private static Logger log = Logger.getLogger(RunReflectionSample.class.getName());

	/**
	 * Main method for the program.
	 * 
	 * @param args
	 *            the arguments for the main method.
	 * @throws NoSuchFieldException
	 *             something went wrong
	 * @throws SecurityException
	 *             something went wrong
	 */
	public static void main(String[] args) throws IllegalAccessException, SecurityException,
			NoSuchFieldException {

		ReflectionClass reflect = new ReflectionClass();

		InputUtils.printConsoleMessage("Set String value for the reflection object");
		reflect.setStringValue(InputUtils.readLine());
		InputUtils.printConsoleMessage("Set integer value for the reflection object");
		reflect.setIntValue(InputUtils.readInt());
		InputUtils.printConsoleMessage("Set float value for the reflection object");
		reflect.setFloatValue(InputUtils.readFlaot());
		InputUtils.printConsoleMessage("Set boolean value for the reflection object 1 - false 0 - true");
		int value = Integer.parseInt(InputUtils.readValidatedLine("[0-1]{1}"));
		if (value == 0) {
			reflect.setBooleanValue(true);
		} else {
			reflect.setBooleanValue(false);
		}
		ClassInformer classInformer = new ClassInformer();
		try {
			classInformer.getObjectFieldsAndMethods(reflect);
		} catch (IllegalArgumentException e) {
			log.error(e);
		}
	}
}
