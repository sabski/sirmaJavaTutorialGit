package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactory;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryImpl;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProduct;
import com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductImpl;

/**
 * Test case for class {@link MyFactoryImpl}
 * 
 * @author Simeon Iliev
 */
public class TestFactoryImpl {

	private MyFactory factory = MyFactoryImpl.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryImpl#createInstance()}
	 * .
	 */
	@Test
	public void testCreateInstance() {
		MyFactoryProduct product = factory.createInstance();
		assertTrue(product instanceof MyFactoryProductImpl);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryImpl#createInstanceByReflection()}
	 * .
	 */
	@Test
	public void testCreateInstanceByReflection() {
		MyFactoryProduct product = factory.createInstanceByReflection();
		assertTrue(product instanceof MyFactoryProductImpl);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryImpl#getInstance()}
	 * .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(factory, MyFactoryImpl.getInstance());
	}

}
