package com.sirma.itt.javacourse.test.intro.mathUtil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.task1.mathUtil.MathUtil;

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
		MathUtil util = new MathUtil();
		assertEquals(5, util.getGreatestCommonDivisor(10, 5));
	}

	/**
	 * Test the getLeastCommonDenominator of MathUtil class.
	 */
	@Test
	public void testLcd() {
		MathUtil util = new MathUtil();
		assertEquals(21, util.getLeastCommonDenominator(3, 7));
	}

}
