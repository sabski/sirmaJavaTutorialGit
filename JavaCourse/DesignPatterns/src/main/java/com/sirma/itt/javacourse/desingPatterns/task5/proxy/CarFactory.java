package com.sirma.itt.javacourse.desingPatterns.task5.proxy;

/**
 * Factory class for car type objects.
 * 
 * @author Simeon Iliev
 */
public class CarFactory {

	private static CarFactory instance;

	private CarFactory() {

	}

	/**
	 * Singelton method that retuns the sole instance of the class.
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
