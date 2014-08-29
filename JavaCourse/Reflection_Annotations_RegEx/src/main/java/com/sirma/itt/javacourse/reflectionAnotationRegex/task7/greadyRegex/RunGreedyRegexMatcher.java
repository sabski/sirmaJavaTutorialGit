package com.sirma.itt.javacourse.reflectionAnotationRegex.task7.greadyRegex;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running gredy regex matc
 * @author simeon
 */
public class RunGreedyRegexMatcher {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IOUtils.printConsoleMessage(IOUtils.editStringWithRegex(IOUtils.readLine(),
				IOUtils.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
