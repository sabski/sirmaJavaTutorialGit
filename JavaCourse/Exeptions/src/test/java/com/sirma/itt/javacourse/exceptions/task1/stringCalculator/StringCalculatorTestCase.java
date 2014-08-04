package com.sirma.itt.javacourse.exceptions.task1.stringCalculator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator.class .
 * 
 * @author simeon
 */
public class StringCalculatorTestCase {

	private String testStringOne = "9999";
	private String testStringTwo = null;
	private String testStringThree = "asdsdad";
	private StringCalculator calculator;

	/**
	 * Set up variables for the test.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculator = new StringCalculator();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator#sumStrings(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSumStrings() {
		assertEquals("10221", calculator.sumStrings(testStringOne, "222"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator#sumStrings(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSumStringsReversedValues() {
		assertEquals("10221", calculator.sumStrings("222", testStringOne));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator#sumStrings(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSumStringsSmallNumbers() {
		assertEquals("322", calculator.sumStrings("222", "100"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator#sumStrings(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testSumStringWithNull() {
		calculator.sumStrings(testStringOne, testStringTwo);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task1.stringCalculator.StringCalculator#sumStrings(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test(expected = NumberFormatException.class)
	public void testNumberFormatExetion() {
		calculator.sumStrings(testStringThree, testStringOne);
	}
}
