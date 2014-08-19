package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.sirma.itt.javacourse.Utils;

/**
 * @author simeon
 */
public class UtilTest {

	private String testString = "ThisIsATest";
	private List<Integer> testList;

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Rule
	public final TextFromStandardInputStream inputMock = TextFromStandardInputStream
			.emptyStandardInputStream();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Integer>();
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readLine()}.
	 */
	@Test
	public void testReadLine() {
		inputMock.provideText(testString);
		String result = Utils.readLine();
		assertEquals(testString, result.replaceAll("\n", ""));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readValidatedLine(java.lang.String)}.
	 */
	@Test
	public void testReadValidatedLine() {
		inputMock.provideText(testString);
		String result = Utils.readValidatedLine(Utils.REGEX_VALIDATOR_LETHERS_ONLY);
		assertEquals(testString, result.replaceAll("\n", ""));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readInt()}.
	 */
	@Test
	public void testReadInt() {
		inputMock.provideText(5 + "");
		int temp = Utils.readInt();
		assertEquals(5, temp);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.Utils#validateStringWithRegex(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testValidateStringWithRegex() {
		assertTrue(Utils.validateStringWithRegex(Utils.REGEX_VALIDATOR_LETHERS_ONLY, testString));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#inputArrayListOfIntegers()}.
	 */
	@Test
	public void testInputArrayListOfIntegers() {
		List<Integer> tempList;
		inputMock.provideText(10 + "\n");
		for (int i = 0; i < 10; i++) {
			testList.add(i);
			inputMock.provideText(i + "\n");
		}
		tempList = Utils.inputArrayListOfIntegers();
		assertTrue(tempList.equals(testList));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#isNull(java.lang.Object)}.
	 */
	@Test
	public void testIsNull() {
		assertTrue(Utils.isNull(null));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#printConsoleMessage(java.lang.String)}.
	 */
	@Test
	public void testPrintConsoleMessage() {
		Utils.printConsoleMessage(testString);
		assertEquals(testString, log.getLog().replaceAll("\n", ""));
		log.clear();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.Utils#editStringWithRegex(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testEditStringWithRegex() {
		String result = Utils.editStringWithRegex(testString, testString, "25");
		assertEquals("25", result);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readChar()}.
	 */
	@Test
	public void testReadChar() {
		inputMock.provideText("a");
		Character a = Utils.readChar();
		assertEquals("a", a);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readFlaot()}.
	 */
	@Test
	public void testReadFlaot() {
		inputMock.provideText("1.2");
		assertEquals(1.2, Utils.readFlaot(), 0.2);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.Utils#readString()}.
	 */
	@Test
	public void testReadString() {
		inputMock.provideText(testString);
		assertEquals(testString, Utils.readString().replaceAll("\n", ""));
	}

}
