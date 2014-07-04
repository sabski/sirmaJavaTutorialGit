package com.sirma.itt.javacourse.test.intro.mathUtil;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.mathUtil.MathUtil;

public class MathUtilUnitTest {

	@Test
	public void testGdc() {
		MathUtil util = new MathUtil();
		assertEquals(5, util.getGreatestCommonDivisor(10, 5));
	}

	@Test
	public void testLcd() {
		MathUtil util = new MathUtil();
		assertEquals(21, util.getLeastCommonDenominator(3, 7));
	}

}
