package com.sirma.itt.javacourse.test.intro.stringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.StringCalculator.StringCalculator;

public class StringCalculatorUnitTest {

	@Test
	public void testSumStrings() {
		StringCalculator calculator = new StringCalculator();

		assertEquals("10000", calculator.sumStrings("1", "9999"));
	}

}
