package com.sirma.itt.javacourse.desing_patterns.task1.abstarct_factory.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.AbstractFactory;
import com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.Factory;
import com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.MyProduct;

/**
 * Test case for class {@link Factory}
 * 
 * @author Simeon Iliev
 */
public class TestFactoryImpl {

	private AbstractFactory factory = Factory.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.Factory#createInstance()}
	 * .
	 */
	@Test
	public void testCreateInstance() {
		MyProduct product = factory.createInstance();
		assertTrue(product instanceof MyProduct);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.Factory#createInstanceByReflection()}
	 * .
	 */
	@Test
	public void testCreateInstanceByReflection() {
		MyProduct product = factory.createInstanceByReflection(MyProduct.class.getCanonicalName());
		assertTrue(product instanceof MyProduct);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desing_patterns.task1.abstract_factory.Factory#getInstance()} .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(factory, Factory.getInstance());
	}

}
