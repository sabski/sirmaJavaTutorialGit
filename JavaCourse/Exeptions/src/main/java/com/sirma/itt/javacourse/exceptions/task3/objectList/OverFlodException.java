package com.sirma.itt.javacourse.exceptions.task3.objectList;

/**
 * @author simeon
 */
public class OverFlodException extends IndexOutOfBoundsException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private static String message = "Array is already full";

	/**
	 * Basic constructor for the exception.
	 */
	public OverFlodException() {
		super(message);
	}

	/**
	 * Message constructor for the exception.
	 * 
	 * @param s
	 */
	public OverFlodException(String s) {
		super(s);
	}

}
