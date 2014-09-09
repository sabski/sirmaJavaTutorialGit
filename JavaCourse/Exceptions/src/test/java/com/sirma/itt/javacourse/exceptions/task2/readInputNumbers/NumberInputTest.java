package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.MathUtil;

/**
 * JUnit test class for
 * {@link com.sirma.itt.javacourse.exceptions.task2.readInputNumbers.NumericInputException}
 * 
 * @author Simeon Iliev
 */
public class NumberInputTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	/**
	 * Sets up variables for test methods.
	 * 
	 * @throws Exception
	 *             Something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		log.clear();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task2.readInputNumbers.NumericInputException}
	 */
	@Test
	public void testRunInput() {
		try {
			if (!MathUtil.checkInputRange(0, 100, 5555)) {
				throw new NumericInputException();
			}
		} catch (NumericInputException e) {
			assertTrue(e instanceof NumericInputException);
		}
	}

	/**
	 * Test method that validates we entered value in range.
	 */
	@Test
	public void testRunInputCorrectValues() {
		assertTrue(MathUtil.checkInputRange(0, 100, 57));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task2.readInputNumbers.NumericInputException}
	 */
	@Test
	public void testRunInputNegativeValues() {

		try {
			if (!MathUtil.checkInputRange(0, 100, -57)) {
				throw new NumericInputException();
			}
		} catch (NumericInputException e) {
			assertTrue(e instanceof NumericInputException);
		} finally {
			log.clear();
		}
	}
}
