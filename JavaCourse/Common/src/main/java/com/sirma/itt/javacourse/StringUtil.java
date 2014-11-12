package com.sirma.itt.javacourse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Utility Class.
 * 
 * @author Simeon Iliev
 */
public class StringUtil {

	public static final String REGEX_VALIDATOR_NUMBERS_ONLY = "^[0-9]*$";
	public static final String REGEX_VALIDATOR_LETHERS_ONLY = "^[a-zA-Z\\s]*$";
	public static final String REGEX_VALIDATOR_EMAIL_ADDRESS = "^[a-zA-Z0-9]*?[^\\s]@([^\\s])*$";
	public static final String REGEX_VALIDATOR_IBANS = "((?!<iban>)BG[0-9]{2})([0-9A-Z\\s]+)(?<![0-9A-Z])(?!<iban>)";
	public static final String REGEX_VALIDATOR_IBANS_ALL = "<iban>[A-Z]{2}[0-9]{2}[0-9A-Z\\s]+</iban>";
	public static final String REGEX_VALIDATOR_X_TAGS = "(<x>)([0-9a-zA-Z\\s]+)(</x>)";
	public static final String REGEX_VALIDATOR_CREDIT_CARD_NUMBERS_VISA = "^4[0-9]{12}(?:[0-9]{3})?$";

	/**
	 * Validates that the given input matches a regular expression.
	 * 
	 * @param regex
	 *            the regular expression that is to matched.
	 * @param inputToverify
	 *            the string that is to be matched.
	 * @return true if the String matches the regex otherwise returns false.
	 */
	public static boolean validateStringWithRegex(String regex, String inputToverify) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputToverify);
		return matcher.matches();
	}

	/**
	 * Takes String input and apples a REGEX expression and replaces the matching text with the
	 * replacement string.
	 * 
	 * @param text
	 *            the text that is to be trimmed
	 * @param regex
	 *            the REGEX expression to be used on the text
	 * @param replacement
	 *            the replacement text that is to be placed on to the matched areas.
	 * @return the text with the replaced areas specified in the REGEX
	 */
	public static String editStringWithRegex(String text, String regex, String replacement) {
		return text.replaceAll(regex, replacement);
	}
}
