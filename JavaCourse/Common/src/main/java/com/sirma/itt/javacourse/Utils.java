package com.sirma.itt.javacourse;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utils class for the JavaCourse Project, this class contains various utility methods.
 * 
 * @author simeon
 */
public class Utils {

	private static Scanner scanner = new Scanner(System.in);
	public static final String REGEX_VALIDATOR_NUMBERS_ONLY = "^[0-9]*$";
	public static final String REGEX_VALIDATOR_LETHERS_ONLY = "\\p{L}";

	/**
	 * Getter method for scanner.
	 * 
	 * @return the scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * Setter method for scanner.
	 * 
	 * @param scanner
	 *            the scanner to set
	 */
	public void setScanner(Scanner scanner) {
		Utils.scanner = scanner;
	}

	/**
	 * Method gets the next console input line.
	 * 
	 * @return the next input line.
	 */
	public static String readLine() {
		return scanner.nextLine();
	}

	/**
	 * Reads the next integer value that is input in the console. If input is not a number an error
	 * message will be printed in the console.
	 * 
	 * @return the number that was inputed thru the console otherwise it returns -1.
	 */
	public static int readLineNumber() {
		Integer input = null;
		input = inputNumber();
		if (input == null) {
			input = readLineNumber();
		}
		return input;
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

	/**
	 * Allows the user to input array list with certain length and user input numbers that are
	 * verified by the class regex.
	 * 
	 * @return an ArrayList of integers that were inputed via the console.
	 */
	public static ArrayList<Integer> inputArrayListOfIntegers() {
		ArrayList<Integer> input = new ArrayList<Integer>();

		int numbersCount = 0;
		System.out.println("Plese input the lenght of the array");
		numbersCount = readLineNumber();
		for (int i = 0; i < numbersCount; i++) {
			printConsoleMessage("Plese input value for " + (i + 1));
			input.add(readLineNumber());
		}
		return input;
	}

	/**
	 * Gets input from the console and prints an error message if the input is incorrect.
	 * 
	 * @return the number that was inputed via the console.
	 */
	private static Integer inputNumber() {
		Integer temp = null;
		try {
			temp = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			printConsoleMessage("Please input number value");
		}
		return temp;
	}

	/**
	 * Checks if given object is null.
	 * 
	 * @param o
	 *            the object we want to check for null
	 * @return true if object is null
	 */
	public static boolean isNull(Object o) {
		if (o == null) {
			return true;
		}

		return false;
	}

	/**
	 * Prints out a message to the console.
	 * 
	 * @param message
	 *            the message to be printed sin the console.
	 */
	public static void printConsoleMessage(String message) {

		System.out.println(message);

	}
}
