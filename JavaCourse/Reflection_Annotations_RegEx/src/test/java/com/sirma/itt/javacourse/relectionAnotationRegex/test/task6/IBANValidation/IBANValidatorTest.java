package com.sirma.itt.javacourse.relectionAnotationRegex.test.task6.IBANValidation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Test class for testing IBAN validation.
 * 
 * @author simeon
 */
public class IBANValidatorTest {

	private String iban = "<bankAccounts>" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>"
			+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
			+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
			+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
			+ "<iban>BG80 BNBG 9661 1020 3456 7840</iban>\n"
			+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
			+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
			+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
			+ "<iban>BG80 BNBG 9661 1020 3456 7843</iban>" + "</bankAccounts>";

	private String result = "<bankAccounts><iban>GR16 0110 1050 0000 1054 7023 795</iban>"
			+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
			+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
			+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n" + "<iban>****7840</iban>\n"
			+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
			+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
			+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
			+ "<iban>****7843</iban></bankAccounts>";

	/**
	 * Test IBAN validation with correct data.
	 */
	@Test
	public void test() {
		assertEquals(result, IOUtils.editStringWithRegex(iban, IOUtils.REGEX_VALIDATOR_IBANS, "****"));
	}

}
