package com.sirma.itt.javacourse.reflectionAnotationRegex.task6.IBANValidation;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.StringUtil;

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

		InputUtils.printConsoleMessage("This is a sample input for the program :  " + sampleData);
		InputUtils.printConsoleMessage("This is a sample ouput of the program : "
				+ StringUtil.editStringWithRegex(sampleData, StringUtil.REGEX_VALIDATOR_IBANS,
						"****"));
		InputUtils.printConsoleMessage("Please input iban ");
		String result;
		do {
			result = InputUtils.readLine();
		} while (!result.matches(StringUtil.REGEX_VALIDATOR_IBANS_ALL));
		InputUtils.printConsoleMessage("The result of the validation is "
				+ StringUtil.editStringWithRegex(result, StringUtil.REGEX_VALIDATOR_IBANS, "****"));
	}

}
