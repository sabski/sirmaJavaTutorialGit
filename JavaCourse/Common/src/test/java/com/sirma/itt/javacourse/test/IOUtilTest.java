package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Unit test for IOUtil.class
 * 
 * @author simeon
 */
public class IOUtilTest {

	private String testString = "ThisIsATest";

	private List<Integer> testList;

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
		String input = "abcd" + "\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		String result = IOUtils.readValidatedLine(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY);
		assertEquals("abcd", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readInt()}.
	 */
	@Test
	public void testReadInt() {
		String input = "5\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
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
		assertTrue(IOUtils
				.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY, testString));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#validateStringWithRegex(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateStringWithRegexFalseValue() {
		assertFalse(IOUtils.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY, "5a3a1"));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#inputListOfIntegers()}.
	 */
	@Test
	public void testInputArrayListOfIntegers() {
		String input = "10\n";
		for (int i = 0; i < 10; i++) {
			testList.add(i + 1);
			input += ((i + 1) + "\n");
		}
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		assertEquals(testList, IOUtils.inputListOfIntegers());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#isNull(java.lang.Object)}.
	 */
	@Test
	public void testIsNull() {
		assertTrue(IOUtils.isNull(null));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#printConsoleMessage(java.lang.String)}.
	 */
	@Test
	public void testPrintConsoleMessage() {
		IOUtils.printConsoleMessage(testString);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.IOUtils#editStringWithRegex(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testEditStringWithRegex() {
		String result = IOUtils.editStringWithRegex(testString, testString, "25");
		assertEquals("25", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readChar()}.
	 */
	@Test
	public void testReadChar() {
		String input = "a\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		Character actial = IOUtils.readChar();
		Character expected = "a".charAt(0);
		assertTrue(expected.equals(actial));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readFlaot()}.
	 */
	@Test
	public void testReadFlaot() {
		String input = "1.5\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		float number = IOUtils.readFlaot();
		assertEquals(1.5, number, 1.0);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.IOUtils#readString()}.
	 */
	@Test
	public void testReadString() {
		String input = "hello\n";
		scanner = new Scanner(input);
		IOUtils.setScanner(scanner);
		assertEquals("hello", IOUtils.readString());

	}

}
