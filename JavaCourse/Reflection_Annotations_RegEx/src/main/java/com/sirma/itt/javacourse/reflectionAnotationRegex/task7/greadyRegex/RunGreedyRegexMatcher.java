package com.sirma.itt.javacourse.reflectionAnotationRegex.task7.greadyRegex;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running greedy Regex matcher.
 * 
 * @author simeon
 */
public class RunGreedyRegexMatcher {

	/**
	 * Main method for the Matcher
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		IOUtils.printConsoleMessage("Input string you want to validate with the following regex "
				+ IOUtils.REGEX_VALIDATOR_X_TAGS);
		IOUtils.printConsoleMessage(IOUtils.editStringWithRegex(IOUtils.readLine(),
				IOUtils.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
