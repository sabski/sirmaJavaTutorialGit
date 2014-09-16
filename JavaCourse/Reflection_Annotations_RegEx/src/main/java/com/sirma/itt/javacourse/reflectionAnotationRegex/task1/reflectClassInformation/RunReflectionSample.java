package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

/**
 * Class for running reflection example.
 * 
 * @author simeon
 */
public class RunReflectionSample {

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

		Reflector reflector = new Reflector();
		try {
			reflector.reflect(reflect);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
