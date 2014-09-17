package com.sirma.itt.javacourse.reflectionAnotationRegex.task5.emailValidator;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that asks a user to enter an email adres an validate it.
 * 
 * @author simeon
 */
public class RunEmailValidator {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {

		IOUtils.printConsoleMessage("Please enter you're email address.");

		String email = IOUtils.readValidatedLine(IOUtils.REGEX_VALIDATOR_EMAIL_ADDRESS);

		IOUtils.printConsoleMessage("Thank you for entering you're email address : " + email);

	}

}
