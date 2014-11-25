package com.sirma.itt.javacourse.desing_patterns.task5.proxy;

/**
 * Factory class for car type objects.
 * 
 * @author Simeon Iliev
 */
public class CarFactory {

	private static CarFactory instance;

	/**
	 * Private constructor.
	 */
	private CarFactory() {

	}

	/**
	 * Singleton method that returns the sole instance of the class.
	 * 
	 * @return the class instance.
	 */
	public static CarFactory getInstance() {
		if (instance == null) {
			instance = new CarFactory();
		}
		return instance;
	}

	/**
	 * Creates a new carProxy object.
	 * 
	 * @return a car proxy.
	 */
	public CarInterface createNewCar() {
		return new CarProxy();
	}
}
