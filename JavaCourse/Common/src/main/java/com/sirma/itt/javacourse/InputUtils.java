package com.sirma.itt.javacourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * InputUtils class for the JavaCourse Project, this class contains various utility methods.
 * 
 * @author simeon
 */
public class InputUtils {

	
	private static Scanner scanner = new Scanner(System.in);
	private static Logger log = Logger.getLogger(InputUtils.class.getName());

	/**
	 * Getter method for scanner.
	 * 
	 * @return the scanner
	 */
	public static Scanner getScanner() {
		return scanner;
	}

	/**
	 * Setter method for scanner.
	 * 
	 * @param scanner
	 *            the scanner to set
	 */
	public static void setScanner(Scanner scanner) {
		InputUtils.scanner = scanner;
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
	 * Method gets the next console input line and validates the input with a regex expression.
	 * 
	 * @return the next input line.
	 */
	public static String readValidatedLine(String regex) {

		String tmp = scanner.nextLine();
		if (StringUtil.validateStringWithRegex(regex, tmp)) {
			return tmp;
		} else {
			printConsoleMessage("Input correct statement");
			return readValidatedLine(regex);
		}

	}

	/**
	 * Reads the next integer value that is input in the console. If input is not a number an error
	 * Message will be printed in the console.
	 * 
	 * @return the number that was inputed thru the console otherwise it returns -1.
	 */
	public static int readInt() {
		Integer input = null;
		input = inputNumber();
		if (input == null) {
			input = readInt();
		}
		return input;
	}

	/**
	 * Allows the user to input array list with certain length and user input numbers that are
	 * verified by the class regex.
	 * 
	 * @return an ArrayList of integers that were inputed via the console.
	 */
	public static List<Integer> inputListOfIntegers() {
		List<Integer> input = new ArrayList<Integer>();

		System.out.println("Please input the length of the array");
		int numbersCount = readInt();
		for (int i = 0; i < numbersCount; i++) {
			printConsoleMessage("Please input value for " + (i + 1));
			input.add(readInt());
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
	 * @param object
	 *            the object we want to check for null
	 * @return true if object is null
	 */
	public static boolean isNull(Object object) {
		if (object == null) {
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
		log.info(message);
	}

	/**
	 * Reads a single Character from the console.
	 * 
	 * @return the read Character.
	 */
	public static Character readChar() {
		Character result = null;
		result = inputChar();
		if (result == null) {
			printConsoleMessage("Input single char.");
			result = readChar();
		}
		return result;
	}

	/**
	 * Reads the console input and accepts any one character as input.
	 * 
	 * @return the character object that was inputed in the console returns null if not a single
	 *         character was inputed.
	 */
	private static Character inputChar() {
		Character result = null;
		String tmp = readLine();
		printConsoleMessage(tmp.length() + "");
		if (tmp.length() > 1) {
			return result;
		}
		try {
			result = tmp.charAt(0);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Reads the console input and assures the return value is of the float type.
	 * 
	 * @return the float value that was inputed in the console.
	 */
	public static float readFlaot() {
		Float result = null;
		result = inputNextFlaot();
		if (result == null) {
			result = readFlaot();
		}
		return result;
	}

	/**
	 * Reads console input and tries to cast it to float type number.
	 * 
	 * @return the inputed number if the input is incorrect returns null object.
	 */
	private static Float inputNextFlaot() {
		Float result = null;
		try {
			result = Float.parseFloat(scanner.nextLine());
		} catch (Exception e) {
			printConsoleMessage("Input correct value");
		}
		return result;
	}

	/**
	 * Reads the next inputed String that contains only leathers.
	 * 
	 * @return the inputed string
	 */
	public static String readString() {
		scanner.reset();
		String result = scanner.nextLine();
		if (!StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY, result)) {
			printConsoleMessage("Input correct data.");
			result = readString();
		}
		return result;
	}

	/**
	 * Reads the contents of a specific file.
	 * 
	 * @param fileName
	 *            the file to be read.
	 * @return the contents of the file as a String Object.
	 * @throws FileNotFoundException
	 */
	public static String readFile(String fileName) throws FileNotFoundException {
		StringBuffer stringBuffer = null;
		File file = new File(fileName);
		if (!file.exists() || file.isDirectory()) {
			printConsoleMessage("Invalid file name");
			throw new FileNotFoundException();
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			String line = null;
			stringBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				printConsoleMessage(line);
				stringBuffer.append(line + "\n");
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return stringBuffer.toString();
	}

	/**
	 * Reads the console input and assures the return value is of the float type.
	 * 
	 * @return the double value that was inputed in the console.
	 */
	public static double readDouble() {
		Double result = null;
		result = inputNextDouble();
		if (result == null) {
			result = readDouble();
		}
		return result;
	}

	/**
	 * Gets input from the console and prints an error message if the input is incorrect.
	 * 
	 * @return the number that was inputed via the console.
	 */
	private static Double inputNextDouble() {
		Double temp = null;
		try {
			temp = Double.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			printConsoleMessage("Please input number value");
		}
		return temp;
	}
}
