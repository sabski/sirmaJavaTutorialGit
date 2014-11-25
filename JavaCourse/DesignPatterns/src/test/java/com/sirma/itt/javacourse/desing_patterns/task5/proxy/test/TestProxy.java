package com.sirma.itt.javacourse.desing_patterns.task5.proxy.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.sirma.itt.javacourse.desing_patterns.task5.proxy.CarFactory;
import com.sirma.itt.javacourse.desing_patterns.task5.proxy.CarInterface;

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
