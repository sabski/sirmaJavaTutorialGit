package com.sirma.itt.javacourse.reflectionAnotationRegex.task7.greadyRegex;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.StringUtil;

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
		InputUtils
				.printConsoleMessage("Input string you want to validate with the following regex "
						+ StringUtil.REGEX_VALIDATOR_X_TAGS);
		InputUtils.printConsoleMessage(StringUtil.editStringWithRegex(InputUtils.readLine(),
				StringUtil.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
