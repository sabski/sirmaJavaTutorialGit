package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.MathUtil;

/**
 * @author simeon
 */
public class TestMathUtil {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.MathUtil#generateRandomNumberWithRange(int, int)}.
	 */
	@Test
	public void testGenerateRandomNumberWithRange() {
		assertEquals(5, MathUtil.generateRandomNumberWithRange(5, 5));
	}

	/**
	 * Test the get getGreatestCommonDivisor of MathUtil class.
	 */
	@Test
	public void getGreatestCommonDivisor() {
		assertEquals(5, com.sirma.itt.javacourse.MathUtil.getGreatestCommonDivisor(10, 5));
	}

	/**
	 * Test the getLeastCommonDenominator of MathUtil class.
	 */
	@Test
	public void getLeastCommonDenominator() {
		assertEquals(21, com.sirma.itt.javacourse.MathUtil.getLeastCommonDenominator(3, 7));
	}

}
