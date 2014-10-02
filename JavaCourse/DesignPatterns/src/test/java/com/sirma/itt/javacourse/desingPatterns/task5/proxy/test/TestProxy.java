package com.sirma.itt.javacourse.desingPatterns.task5.proxy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.sirma.itt.javacourse.desingPatterns.task5.proxy.Car;
import com.sirma.itt.javacourse.desingPatterns.task5.proxy.CarFactory;
import com.sirma.itt.javacourse.desingPatterns.task5.proxy.CarInterface;
import com.sirma.itt.javacourse.desingPatterns.task5.proxy.CarProxy;

/**
 * Test class for proxy testing
 * 
 * @author Simeon Iliev
 */
public class TestProxy {

	private CarInterface car;
	private String brand;
	private String model;
	private String result;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		brand = "BMW";
		model = "M3";
		result = "Brand : " + brand + "Model : " + model;
		car = CarFactory.getInstance().createNewCar();
	}

	/**
	 * If data enterd in the car is correct.
	 */
	@Test
	public void test() {
		car.setUpCar(model, brand, 150, 5);
		assertEquals(result, car.getBrandAndModel());
	}

}
