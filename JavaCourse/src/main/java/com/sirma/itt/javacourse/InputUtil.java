package com.sirma.itt.javacourse;

import java.util.Scanner;

/**
 * @author simeon
 */
public class InputUtil {

	private static Scanner scaner = new Scanner(System.in);
	public static final String REGEX_VALIDATOR_NUMBERS_ONLY = "^[0-9]*$";
	public static final String REGEX_VALIDATOR_LETHERS_ONLY = "\\p{L}";

	/**
	 * Getter method for scaner.
	 * 
	 * @return the scaner
	 */
	public Scanner getScaner() {
		return scaner;
	}

	/**
	 * Setter method for scaner.
	 * 
	 * @param scaner
	 *            the scaner to set
	 */
	public void setScaner(Scanner scaner) {
		InputUtil.scaner = scaner;
	}

	/**
	 * Method gets the next console input line.
	 * 
	 * @return the next input line.
	 */
	public static String readLine() {
		return scaner.nextLine();
	}

	/**
	 * Reads the next integer value that is input in the console. If input is not a number an error
	 * message will be printed in the console.
	 * 
	 * @return the number that was inputed thru the console otherwise it returns -1.
	 */
	public static int readLineNumber() {
		int temp = -1;
		try {
			temp = scaner.nextInt();
		} catch (Exception e) {
			System.out.println("Pleaze input number value");
		}
		return temp;
	}

	/**
	 * Validates that the given input matches a regular expression.
	 * 
	 * @param regex
	 *            the regular expression that is to matched.
	 * @param inputToverify
	 *            the string that is to be matched.
	 * @return true if the String matches the regex otherwise returns false.
	 */
	public static boolean validateStringWithREgex(String regex, String inputToverify) {
		return inputToverify.matches(regex);
	}
}
