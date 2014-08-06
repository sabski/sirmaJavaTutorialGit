package com.sirma.itt.javacourse.reflectionAnotationRegex.task6.IBANValidation;

import com.sirma.itt.javacourse.Utils;

/**
 * Class for running the IBAN validator.
 * 
 * @author simeon
 */
public class RunIBANValidator {

	/**
	 * Main method for the program
	 * 
	 * @param args
	 *            arguments for the main method
	 */
	public static void main(String[] args) {

		IBANValidator validator = new IBANValidator();

		Utils.printConsoleMessage("This is a sample input for the program :  "
				+ validator.getIbanSampleString());
		Utils.printConsoleMessage("This is a samole ouput of the program : "
				+ validator.validateIban(validator.getIbanSampleString()));
		Utils.printConsoleMessage("Please input iban ");
		String result = validator.validateIban(Utils.readLine());
		Utils.printConsoleMessage("The result of the validation is " + result);
	}

}
