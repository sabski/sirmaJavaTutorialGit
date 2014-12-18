package com.sirma.itt.javacourse.desingpatterns.task5.proxy;

/**
 * Runner class.
 * 
 * @author Simeon Iliev
 */
public class RunCarProxy {

	/**
	 * Maim method.
	 * 
	 * @param args
	 *            argument for the main method.
	 */
	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
		CarInterface myCar = factory.createNewCar();
		myCar.setUpCar("", "", 0, 0);
	}

}
