package com.sirma.itt.javacourse.desing_patterns.task1.abstarct_factory.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.AbstractFactory;
import com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.Factory;
import com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.MyProduct;

/**
 * Test case for class {@link Factory}
 * 
 * @author Simeon Iliev
 */
public class TestFactoryImpl {

	private AbstractFactory factory = Factory.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.Factory#createInstance()}
	 * .
	 */
	@Test
	public void testCreateInstance() {
		MyProduct product = factory.createInstance();
		assertTrue(product instanceof MyProduct);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.Factory#createInstanceByReflection()}
	 * .
	 */
	@Test
	public void testCreateInstanceByReflection() {
		MyProduct product = factory.createInstanceByReflection(MyProduct.class.getCanonicalName());
		assertTrue(product instanceof MyProduct);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory.Factory#getInstance()} .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(factory, Factory.getInstance());
	}

}
