package com.sirma.itt.javacourse.desingPatterns.task3.singeleton.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task3.singleton.MySingletonClass;

/**
 * Test class for {@link MySingletonClass}
 * 
 * @author Simeon Iliev
 */
public class TestSingleton {

	private MySingletonClass singleton = MySingletonClass.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task3.singleton.MySingletonClass#getInstance()}
	 * .
	 */
	@Test
	public void testGetInstance() {
		assertEquals(singleton, MySingletonClass.getInstance());
	}

}
