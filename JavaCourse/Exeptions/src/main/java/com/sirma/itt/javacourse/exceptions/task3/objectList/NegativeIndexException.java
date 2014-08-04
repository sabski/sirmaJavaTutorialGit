package com.sirma.itt.javacourse.exceptions.task3.objectList;

/**
 * Intercept a negative index exception.
 * 
 * @author simeon
 */
public class NegativeIndexException extends ArrayIndexOutOfBoundsException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private static String message = "No more ellements in the array";

	/**
	 * Basic constructor for the exception.
	 */
	public NegativeIndexException() {
		super(message);
	}

	/**
	 * Message constructor for the exception.
	 * 
	 * @param s
	 *            the message to be displayed.
	 */
	public NegativeIndexException(String s) {
		super(message);
	}

}
