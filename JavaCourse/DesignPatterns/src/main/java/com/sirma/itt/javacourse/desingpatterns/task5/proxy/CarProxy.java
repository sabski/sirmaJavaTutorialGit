package com.sirma.itt.javacourse.desingpatterns.task5.proxy;

/**
 * Car proxy class.
 * 
 * @author Simeon Iliev
 */
public class CarProxy implements CarInterface {

	private Car car;

	@Override
	public void setUpCar(String model, String brand, int hoursePower, int fuellUssage) {
		car = new Car();
		car.setUpCar(model, brand, hoursePower, fuellUssage);
	}

	@Override
	public String getBrandAndModel() {
		return car.getBrandAndModel();
	}

}
