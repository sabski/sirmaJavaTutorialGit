package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

/**
 * A very private class contains much private methods and fields.
 * 
 * @author simeon
 */
public class MyPrivateClass {

	private int myPrivateNumber = 22225;
	private String privateString = "Private String value";
	private float myPieceOfPie = 3.14f;

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
