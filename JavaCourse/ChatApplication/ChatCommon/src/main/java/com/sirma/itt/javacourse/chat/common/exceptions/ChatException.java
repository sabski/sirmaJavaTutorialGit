/**
 * 
 */
package com.sirma.itt.javacourse.chat.common.exceptions;

/**
 * Basic chat exception.
 * 
 * @author siliev
 * 
 */
public class ChatException extends Exception {

	private static final long serialVersionUID = -6422086764162437854L;

	/**
	 * Empty constructor.
	 */
	public ChatException() {

	}

	/**
	 * Constructor with message and cause.
	 * 
	 * @param message
	 *            the error message.
	 * @param cause
	 *            the cause of the exception.
	 */
	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Messaged constructor.
	 * 
	 * @param message
	 *            the error message.
	 */
	public ChatException(String message) {
		super(message);
	}

	/**
	 * Constructor with cause.
	 * 
	 * @param cause
	 *            the cause of the exception.
	 */
	public ChatException(Throwable cause) {
		super(cause);
	}

}
