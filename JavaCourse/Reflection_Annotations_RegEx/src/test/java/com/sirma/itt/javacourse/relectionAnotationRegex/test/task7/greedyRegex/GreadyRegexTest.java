package com.sirma.itt.javacourse.relectionAnotationRegex.test.task7.greedyRegex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.Utils;

/**
 * Unit test for GreadyRegex expression.
 * 
 * @author simeon
 */
public class GreadyRegexTest {

	private String input = "<x><b></b><x>Hello world</x>\n" + "<b>sdfsdf</b><x>Good\n"
			+ "morning</x><x>69</x>" + "<x>sdfsdfsdf</x>\n</x>";

	private String result = "<x><b></b><x/>\n" + "<b>sdfsdf</b><x/><x/><x/>\n" + "</x>";

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test that the RegEx Expression works properly. 
	 */
	@Test
	public void test() {
		
		assertEquals(result, Utils.editStringWithRegex(input, Utils.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
