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

	public static final String INVALID_POSTAL_CODE = "Невалиден пощенски код";

	public static final String INVALID_EGN = "Грешно ЕГН";

	public static final String INVALID_CARD_NUMBER = "Невалиден номер на дебитната карта";

	private static final String SEPARATOR = System.getProperty("line.separator").toString();

	private Map<String, String> exceptions;

	private String message = "";

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
		exceptions.put("first", INVALID_CARD_NUMBER);
		exceptions.put("second", INVALID_EGN);
		exceptions.put("third", INVALID_POSTAL_CODE);
	}

	/**
	 * @param messageCode
	 * @return
	 * @throws InvalidAttributesException
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
	 */
	public static Collection<String> getMesages(String messagesCombination) {
		Collection<String> result = Arrays.asList(messagesCombination.split(SEPARATOR));

		return result;
	}

}
