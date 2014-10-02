package com.sirma.itt.javacourse.desingPatterns.task5.proxy;

/**
 * Interface for the car.
 * 
 * @author Simeon Iliev
 */
public interface CarInterface {

	/**
	 * Set up method for car type objects
	 * 
	 * @param model
	 *            the model of the car.
	 * @param brand
	 *            the brand of the car.
	 * @param hoursePower
	 *            the hourse power of the car.
	 * @param fuellUssage
	 *            the fuel ussage of the car
	 */
	public void setUpCar(String model, String brand, int hoursePower, int fuellUssage);

	/**
	 * Retuns the car brand and model.
	 * 
	 * @return the cars brand and model.
	 */
	public String getBrandAndModel();
}
