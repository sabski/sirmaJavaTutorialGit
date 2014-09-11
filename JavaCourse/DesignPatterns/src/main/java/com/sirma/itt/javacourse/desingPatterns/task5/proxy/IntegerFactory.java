package com.sirma.itt.javacourse.desingPatterns.task5.proxy;

/**
 * Integer Factory class.
 * 
 * @author Simeon Iliev
 */
public class IntegerFactory {

	private static IntegerFactory instance;

	/**
	 * Singelton constructor.
	 */
	private IntegerFactory() {

	}

	/**
	 * Singleton method that returns the sole instance of the factory class.
	 * 
	 * @return
	 */
	public static IntegerFactory getInstance() {
		if (instance == null) {
			instance = new IntegerFactory();
		}
		return instance;
	}

	/**
	 * Creates a new Integer instance with value 0.
	 * 
	 * @return the new instance.
	 */
	public Integer createInstance() {
		return new Integer(0);
	}
}
