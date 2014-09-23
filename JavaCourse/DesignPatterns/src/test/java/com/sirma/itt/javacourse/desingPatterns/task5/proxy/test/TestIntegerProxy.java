package com.sirma.itt.javacourse.desingPatterns.task5.proxy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task5.proxy.IntegerProxy;

/**
 * @author Simeon Iliev
 */
public class TestIntegerProxy {

	private Integer testInt = null;
	private IntegerProxy proxy;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proxy = new IntegerProxy();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task5.proxy.IntegerProxy#loadInt()}.
	 */
	@Test
	public void testLoadInt() {
		assertTrue(proxy.loadInt() != null);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task5.proxy.IntegerProxy#loadInt()}.
	 */
	@Test
	public void testLoadIntValue() {
		testInt = proxy.loadInt();
		assertTrue(testInt == 0);
	}

}
