package com.sirma.itt.javacourse.reflectionAnotationRegex.task6.IBANValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sirma.itt.javacourse.IOUtils;

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
		String sampleData = "<bankAccounts>" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>"
				+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
				+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
				+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
				+ "<iban>BG80 BNBG 9661 1020 3456 7840</iban>\n"
				+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
				+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
				+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
				+ "<iban>BG80 BNBG 9661 1020 3456 7843</iban>" + "</bankAccounts>";

		IOUtils.printConsoleMessage("This is a sample input for the program :  " + sampleData);
		IOUtils.printConsoleMessage("This is a sample ouput of the program : "
				+ IOUtils.editStringWithRegex(sampleData, IOUtils.REGEX_VALIDATOR_IBANS, "****"));
		IOUtils.printConsoleMessage("Please input iban ");
		String result;
		do {
			result = IOUtils.readLine();
		} while (!result.matches(IOUtils.REGEX_VALIDATOR_IBANS_ALL));
		IOUtils.printConsoleMessage("The result of the validation is "
				+ IOUtils.editStringWithRegex(result, IOUtils.REGEX_VALIDATOR_IBANS, "****"));
	}

}
