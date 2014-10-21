package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import com.sirma.itt.javacourse.IOUtils;

/**
 * A class that contains various fields and methods.
 * 
 * @author Simeon Iliev
 */
public class ReflectionClass {

	public int intValue = 14;

	protected boolean booleanValue = false;

	float floatValue = 3f;

	private String stringValue = "Lendo galendo";

	/**
	 * Prints some of the elements..
	 */
	public void print() {
		IOUtils.printConsoleMessage(stringValue + floatValue + booleanValue);

	}

	/**
	 * Getter method for intValue.
	 * 
	 * @return the intValue
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * Setter method for intValue.
	 * 
	 * @param intValue
	 *            the intValue to set
	 */
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * Getter method for booleanValue.
	 * 
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * Setter method for booleanValue.
	 * 
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * Getter method for floatValue.
	 * 
	 * @return the floatValue
	 */
	public float getFloatValue() {
		return floatValue;
	}

	/**
	 * Setter method for floatValue.
	 * 
	 * @param floatValue
	 *            the floatValue to set
	 */
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	/**
	 * Getter method for stringValue.
	 * 
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Setter method for stringValue.
	 * 
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
