package com.sirma.itt.javacourse.test.intro.stringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.stringCalculator.StringCalculator;

/**
 * 
 * 
 * @author simeon
 */
public class StringCalculatorUnitTest {

	/**
	 * Test the StringSumator.
	 */
	@Test
	public void testSumStrings() {
		StringCalculator calculator = new StringCalculator();

		assertEquals("10000", calculator.sumStrings("1", "9999"));
	}

}
