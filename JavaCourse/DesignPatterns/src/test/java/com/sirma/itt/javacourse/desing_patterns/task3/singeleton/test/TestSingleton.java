package com.sirma.itt.javacourse.desing_patterns.task3.singeleton.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task3.singleton.MySingletonClass;

/**
 * Test class for {@link MySingletonClass}
 * 
 * @author Simeon Iliev
 */
public class TestSingleton {

	private final MySingletonClass singleton = MySingletonClass.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task3.singleton.MySingletonClass#getInstance()}
	 * .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(singleton, MySingletonClass.getInstance());
	}

}
