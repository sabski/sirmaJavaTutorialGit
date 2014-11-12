package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.StringUtil;

/**
 * Unit test for IOUtil.class
 * 
 * @author simeon
 */
public class IOUtilTest {

	private final String testString = "ThisIsATest";

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
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#readLine()}.
	 */
	@Test
	public void testReadLine() {
		String input = "10\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		assertEquals("10", InputUtils.readLine());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.InputUtils#readValidatedLine(java.lang.String)}.
	 */
	@Test
	public void testReadValidatedLine() {
		String input = "abcd" + "\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		String result = InputUtils.readValidatedLine(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY);
		assertEquals("abcd", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#readInt()}.
	 */
	@Test
	public void testReadInt() {
		String input = "5\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		int result = InputUtils.readInt();
		assertEquals(5, result);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.InputUtils#validateStringWithRegex(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateStringWithRegex() {
		assertTrue(StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY,
				testString));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.InputUtils#validateStringWithRegex(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateStringWithRegexFalseValue() {
		assertFalse(StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY,
				"5a3a1"));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#inputListOfIntegers()}.
	 */
	@Test
	public void testInputArrayListOfIntegers() {
		String input = "10\n";
		for (int i = 0; i < 10; i++) {
			testList.add(i + 1);
			input += ((i + 1) + "\n");
		}
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		assertEquals(testList, InputUtils.inputListOfIntegers());
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#isNull(java.lang.Object)}.
	 */
	@Test
	public void testIsNull() {
		assertTrue(InputUtils.isNull(null));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.InputUtils#printConsoleMessage(java.lang.String)}.
	 */
	@Test
	public void testPrintConsoleMessage() {
		InputUtils.printConsoleMessage(testString);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.InputUtils#editStringWithRegex(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testEditStringWithRegex() {
		String result = StringUtil.editStringWithRegex(testString, testString, "25");
		assertEquals("25", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#readChar()}.
	 */
	@Test
	public void testReadChar() {
		String input = "a\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		Character actial = InputUtils.readChar();
		Character expected = "a".charAt(0);
		assertTrue(expected.equals(actial));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#readFlaot()}.
	 */
	@Test
	public void testReadFlaot() {
		String input = "1.5\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		float number = InputUtils.readFlaot();
		assertEquals(1.5, number, 1.0);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.InputUtils#readString()}.
	 */
	@Test
	public void testReadString() {
		String input = "hello\n";
		scanner = new Scanner(input);
		InputUtils.setScanner(scanner);
		assertEquals("hello", InputUtils.readString());

	}

}
