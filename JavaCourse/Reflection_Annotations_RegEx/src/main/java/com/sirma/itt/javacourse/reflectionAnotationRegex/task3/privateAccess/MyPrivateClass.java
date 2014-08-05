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

	private String getMessage(String message) {
		
		return message;
	}
}
