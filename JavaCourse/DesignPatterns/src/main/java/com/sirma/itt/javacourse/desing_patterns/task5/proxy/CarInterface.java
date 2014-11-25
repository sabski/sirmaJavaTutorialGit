package com.sirma.itt.javacourse.desing_patterns.task5.proxy;

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
	 * @param horsePower
	 *            the horse power of the car.
	 * @param fuellUssage
	 *            the fuel usage of the car
	 */
	public void setUpCar(String model, String brand, int horsePower, int fuellUssage);

	/**
	 * Retuns the car brand and model.
	 * 
	 * @return the cars brand and model.
	 */
	public String getBrandAndModel();
}
