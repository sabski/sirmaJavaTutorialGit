package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

/**
 * A very private class contains much private methods and fields.
 * 
 * @author simeon
 */
public class MyPrivateClass {

	private int integerValue = 22225;
	private String stringValue = "Private String value";
	private float floatValue = 1.2f;

	/**
	 * @param integerValue
	 *            the private user number.
	 * @param stringValue
	 *            users private string
	 * @param floatValue
	 *            some float value
	 */
	public MyPrivateClass(int integerValue, String stringValue, float floatValue) {
		this.integerValue = integerValue;
		this.stringValue = stringValue;
		this.floatValue = floatValue;
	}

	/**
	 * Private method that accept a string and returns it.
	 * 
	 * @param message
	 *            the message to be returned.
	 * @return the message the user entered.
	 */
	private String getMessage(String message) {

		return message;
	}
}
