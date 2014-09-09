package com.sirma.itt.javacourse.relectionAnotationRegex.test.task7.greedyRegex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Unit test for GreadyRegex expression.
 * 
 * @author simeon
 */
public class GreadyRegexTest {

	private String input = "<x><b></b><x>Hello world</x>\n" + "<b>sdfsdf</b><x>Good\n"
			+ "morning</x><x>69</x>" + "<x>sdfsdfsdf</x>\n</x>";

	private String result = "<x><b></b><x/>\n" + "<b>sdfsdf</b><x/><x/><x/>\n" + "</x>";

	/**
	 * Test that the RegEx Expression works properly.
	 */
	@Test
	public void testVAlidRegexValues() {

		assertEquals(result,
				IOUtils.editStringWithRegex(input, IOUtils.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
