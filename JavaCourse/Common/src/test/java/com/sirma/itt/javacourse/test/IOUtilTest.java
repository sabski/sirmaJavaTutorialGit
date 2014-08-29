package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.IOUtils;

/**
 * @author simeon
 */
public class IOUtilTest {

	private String testString = "ThisIsATest";
	private List<Integer> testList;

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Rule
	public final TextFromStandardInputStream inputMock = TextFromStandardInputStream
			.emptyStandardInputStream();

	private Scanner scanner;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Integer>();
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readLine()}.
	 */
	@Test
	public void testReadLine() {
		String input = "10\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		assertEquals("10", IOUtils.readLine());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readValidatedLine(java.lang.String)}.
	 */
	@Test
	public void testReadValidatedLine() {
		String input = testString + "\n";
		scanner = new Scanner(input);
		String result = IOUtils.readValidatedLine(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY);
		assertEquals(testString, result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readInt()}.
	 */
	@Test
	public void testReadInt() {
		String input = "5\n";
		scanner = new Scanner(input);
		int result = IOUtils.readInt();
		assertEquals(5, result);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#validateStringWithRegex(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateStringWithRegex() {
		// assertTrue(IOUtils.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY,
		// testString));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#inputArrayListOfIntegers()}.
	 */
	@Test
	public void testInputArrayListOfIntegers() {
		/*
		 * List<Integer> tempList; inputMock.provideText(10 + "\n"); for (int i = 0; i < 10; i++) {
		 * testList.add(i); inputMock.provideText(i + "\n"); } tempList =
		 * IOUtils.inputArrayListOfIntegers(); assertTrue(tempList.equals(testList));
		 */}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#isNull(java.lang.Object)}.
	 */
	@Test
	public void testIsNull() {
		// assertTrue(IOUtils.isNull(null));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#printConsoleMessage(java.lang.String)}.
	 */
	@Test
	public void testPrintConsoleMessage() {
		// IOUtils.printConsoleMessage(testString);
		// assertEquals(testString, log.getLog().replaceAll("\n", ""));
		// log.clear();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#editStringWithRegex(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testEditStringWithRegex() {
		// String result = IOUtils.editStringWithRegex(testString, testString, "25");
		// assertEquals("25", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readChar()}.
	 */
	@Test
	public void testReadChar() {
		// inputMock.provideText("a");
		// Character a = IOUtils.readChar();
		// assertEquals("a", a);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readFlaot()}.
	 */
	@Test
	public void testReadFlaot() {
		// inputMock.provideText("1.2");
		// assertEquals(1.2, IOUtils.readFlaot(), 0.2);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readString()}.
	 */
	@Test
	public void testReadString() {
		// inputMock.provideText(testString);
		// assertEquals(testString, IOUtils.readString().replaceAll("\n", ""));
	}

}
