package com.sirma.itt.javacourse.desingPatterns.task7.calculator.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Test class for {@link NumberOperations}
 * 
 * @author Simeon Iliev
 */
public class TestNumberOperations {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations#additionNumbers(java.lang.Double, java.lang.Double)}
	 * .
	 */
	@Test
	public void testAdditionNumbers() {
		assertEquals(3d, NumberOperations.additionNumbers(1d, 2d), 0.03d);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations#subtractNumbers(java.lang.Double, java.lang.Double)}
	 * .
	 */
	@Test
	public void testSubtractNumbers() {
		assertEquals(3d, NumberOperations.subtractNumbers(5d, 2d), 0.03d);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations#multiplyNumbers(java.lang.Double, java.lang.Double)}
	 * .
	 */
	@Test
	public void testMultiplyNumbers() {
		assertEquals(6d, NumberOperations.multiplyNumbers(3d, 2d), 0.03d);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations#divideNumbers(java.lang.Double, java.lang.Double)}
	 * .
	 */
	@Test
	public void testDivideNumbers() {
		assertEquals(3d, NumberOperations.divideNumbers(6d, 2d), 0.03d);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations#oddFuncthion(java.lang.Double, java.lang.Double)}
	 * .
	 */
	@Test
	public void testOddFuncthion() {
		assertEquals(27d, NumberOperations.oddFuncthion(3d, 3d), 0.03d);
	}

}
