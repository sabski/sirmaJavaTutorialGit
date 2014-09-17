package com.sirma.itt.javacourse.exceptions.task2.readInputNumbers;

import java.io.IOException;

/**
 * Numeric input exception to detect invalid number input.
 * 
 * @author simeon
 */
public class NumericInputException extends IOException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private static final String message = "Number input is not in valid range";

	/**
	 * Super constructor.
	 */
	public NumericInputException() {
		super(message);
	}

	/**
	 * @param message
	 *            the message to be displayed
	 * @param cause
	 *            the cause of the exception
	 */
	public NumericInputException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 *            the message to be displayed in the console.
	 */
	public NumericInputException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 *            the cause of the exception.
	 */
	public NumericInputException(Throwable cause) {
		super(cause);
	}

}
