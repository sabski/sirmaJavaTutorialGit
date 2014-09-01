package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.MathUtil;

public class NumberInputTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Before
	public void setUp() throws Exception {
		log.clear();
	}

	@Test
	public void testRunInput() {
		try {
			if (!MathUtil.runInput(0, 100, 5555)) {
				throw new NumericInputException();
			}
		} catch (NumericInputException e) {
			// TODO Auto-generated catch block
			assertTrue(e instanceof NumericInputException);
		}
	}

	@Test
	public void testRunInputCorrectValues() {

		try {
			if (!MathUtil.runInput(0, 100, 57)) {
				throw new NumericInputException();
			}
			assertTrue(log.getLog().contains("Try again :P"));
		} catch (NumericInputException e) {
			e.printStackTrace();
		} finally {
			log.clear();
		}
	}

	@Test
	public void testRunInputNegativeValues() {

		try {
			if (!MathUtil.runInput(0, 100, -57)) {
				throw new NumericInputException();
			}
		} catch (NumericInputException e) {
			assertTrue(e instanceof NumericInputException);
		} finally {
			log.clear();
		}
	}
}
