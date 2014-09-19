package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactory;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryAImpl;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProduct;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductAImpl;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductImpl;

/**
 * @author Simeon Iliev
 */
public class TestSecondFactoryImpl {

	private MyFactory factory = MyFactoryAImpl.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryAImpl#createInstance()}
	 * .
	 */
	@Test
	public void testCreateInstance() {
		MyFactoryProduct product = factory.createInstance();
		assertTrue(product instanceof MyFactoryProductAImpl);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryAImpl#createInstanceByReflection()}
	 * .
	 */
	@Test
	public void testCreateInstanceByReflection() {
		MyFactoryProduct product = factory.createInstanceByReflection();
		assertTrue(product instanceof MyFactoryProductAImpl);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryAImpl#getInstance()}
	 * .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(factory, MyFactoryAImpl.getInstance());
	}

}
