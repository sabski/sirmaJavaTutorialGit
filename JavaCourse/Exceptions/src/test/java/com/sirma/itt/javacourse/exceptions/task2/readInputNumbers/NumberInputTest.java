package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

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
			NumberInputRun.runInput(5555);
		} catch (NumericInputException e) {
			// TODO Auto-generated catch block
			assertTrue(e instanceof NumericInputException);
		}
	}

	@Test
	public void testRunInputCorrectValues() {

		try {
			NumberInputRun.runInput(57);
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
			NumberInputRun.runInput(-57);
		} catch (NumericInputException e) {
			assertTrue(e instanceof NumericInputException);
		} finally {
			log.clear();
		}
	}
}
