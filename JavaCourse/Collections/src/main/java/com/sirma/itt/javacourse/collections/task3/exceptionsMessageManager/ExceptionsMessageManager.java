package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributesException;

/**
 * Class that Manages Exception messages.
 * 
 * @author simeon
 */
public class ExceptionsMessageManager {

	/**
	 * Constant that contain a key value in the manger.
	 */
	public static final String THIRD = "third";

	/**
	 * Constant that contain a key value in the manger.
	 */
	public static final String SECOND = "second";

	/**
	 * Constant that contain a key value in the manger.
	 */
	public static final String FIRST = "first";

	/**
	 * Constant that contain a value in the manger.
	 */
	public static final String INVALID_POSTAL_CODE = "Invalid postal code";

	/**
	 * Constant that contain a value in the manger.
	 */

	public static final String INVALID_EGN = "Invalid EGN";

	/**
	 * Constant that contain a value in the manger.
	 */
	public static final String INVALID_CARD_NUMBER = "Invalid card number";

	/**
	 * Constant that contain a value in the manger.
	 */
	public static final String SEPARATOR = System.getProperty("line.separator");

	private final Map<String, String> exceptions;

	private String message = "";

	// private static Logger log = Logger.getLogger(ExceptionsMessageManager.class.getName());

	/**
	 * Adds an exception message that is from the map, otherwise throws an exception.
	 * 
	 * @param mess
	 *            the exception message to be added.
	 * @return all the error messages in one string.
	 * @throws InvalidAttributesException
	 */
	public String addExceptionMessage(String mess) throws InvalidAttributesException {
		if (!exceptions.containsValue(mess)) {
			throw new InvalidAttributesException();
		}

		return message += (mess + SEPARATOR);
	}

	/**
	 * Constructor for the ExceptionsMessageManager class.
	 */
	public ExceptionsMessageManager() {
		exceptions = new HashMap<String, String>();
		exceptions.put(FIRST, INVALID_CARD_NUMBER);
		exceptions.put(SECOND, INVALID_EGN);
		exceptions.put(THIRD, INVALID_POSTAL_CODE);
	}

	/**
	 * Add an exception message to the current list of messages. This method should be used the
	 * following way : myManager.addExceptionMessageUsingCode(ExceptionsMessageManager.THIRD)).
	 * 
	 * @param messageCode
	 *            the code of the message.
	 * @return the full message String.
	 * @throws InvalidAttributesException
	 *             if a invalid code was given.
	 */
	public String addExceptionMessageUsingCode(String messageCode)
			throws InvalidAttributesException {
		if (!exceptions.containsKey(messageCode)) {
			throw new InvalidAttributesException();
		}

		return message += (exceptions.get(messageCode) + SEPARATOR);
	}

	/**
	 * Gives the current message.
	 * 
	 * @return the current message;
	 */
	public String getMesage() {
		return message;
	}

	/**
	 * Transforms the message into a list with a line separator as divider.
	 * 
	 * @return the full list of messages.
	 * @throws InvalidAttributesException
	 *             if the String value that was given to the method doesn't contain none of the
	 *             managed values.
	 */
	public static Collection<String> getMesages(String messagesCombination)
			throws InvalidAttributesException {
		if (!messagesCombination.contains(INVALID_POSTAL_CODE)
				&& !messagesCombination.contains(INVALID_CARD_NUMBER)
				&& !messagesCombination.contains(INVALID_EGN)) {
			throw new InvalidAttributesException();
		}
		Collection<String> result = Arrays.asList(messagesCombination.split(SEPARATOR));
		return result;
	}

}
