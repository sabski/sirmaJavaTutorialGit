package com.sirma.itt.javacourse.desingPatterns.task4.objectPool;

/**
 * Exception that will be thrown when there are no more resources to allocate.
 * 
 * @author Simeon Iliev
 */
public class NoMoreResourcesException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Basic constructor
	 */
	public NoMoreResourcesException() {
		super();
	}

	/**
	 * Message and cause constructor.
	 * 
	 * @param message
	 *            the message of the exception.
	 * @param cause
	 *            The cause of the exception.
	 */
	public NoMoreResourcesException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Message constructor.
	 * 
	 * @param message
	 *            the message of the exception.
	 */
	public NoMoreResourcesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cause constructor.
	 * 
	 * @param cause
	 *            The cause of the exception.
	 */
	public NoMoreResourcesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
