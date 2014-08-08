package com.sirma.itt.javacourse.reflectionAnotationRegex.task7.greadyRegex;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for running gredy regex matc
 * @author simeon
 */
public class RunGreedyRegexMatcher {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Utils.printConsoleMessage(Utils.editStringWithRegex(Utils.readLine(),
				Utils.REGEX_VALIDATOR_X_TAGS, "<x/>"));
	}

}
