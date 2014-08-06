package com.sirma.itt.javacourse.reflectionAnotationRegex.task5.emailValidator;

import org.apache.commons.validator.EmailValidator;

import com.sirma.itt.javacourse.Utils;

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

		Utils.printConsoleMessage("Please enter youre email address.");

		String email = Utils.readValidatedLine(Utils.REGEX_VALIDATOR_EMAIL_ADDRESS);

		Utils.printConsoleMessage("Thank you for entaring youre email address.");

	}

}
