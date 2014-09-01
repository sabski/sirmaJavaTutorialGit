package com.sirma.itt.javacourse.test.intro.task1.mathUtil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for the MathUtil class.
 * 
 * @author simeon
 */
public class MathUtilUnitTest {

	/**
	 * Test the get getGreatestCommonDivisor of MathUtil class.
	 */
	@Test
	public void testGdc() {
		assertEquals(5, com.sirma.itt.javacourse.MathUtil.getGreatestCommonDivisor(10, 5));
	}

	/**
	 * Test the getLeastCommonDenominator of MathUtil class.
	 */
	@Test
	public void testLcd() {
		assertEquals(21, com.sirma.itt.javacourse.MathUtil.getLeastCommonDenominator(3, 7));
	}

}
