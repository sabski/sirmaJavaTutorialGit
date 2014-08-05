package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import com.sirma.itt.javacourse.Utils;

/**
 * A class that contains various fields and methods.
 * 
 * @author simeon
 */
public class ReflectionClass {

	public int intValue = 14;

	protected boolean lie = false;

	float pie = 3.14f;

	private String string = "Lendo galendo";
	

	/**
	 * Prints some of the elements..
	 */
	public void print() {
		Utils.printConsoleMessage(string + pie + lie);

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
	 * Getter method for lie.
	 * 
	 * @return the lie
	 */
	public boolean isLie() {
		return lie;
	}

	/**
	 * Setter method for lie.
	 * 
	 * @param lie
	 *            the lie to set
	 */
	public void setLie(boolean lie) {
		this.lie = lie;
	}

	/**
	 * Getter method for pie.
	 * 
	 * @return the pie
	 */
	public float getPie() {
		return pie;
	}

	/**
	 * Setter method for pie.
	 * 
	 * @param pie
	 *            the pie to set
	 */
	public void setPie(float pie) {
		this.pie = pie;
	}

	/**
	 * Getter method for string.
	 * 
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * Setter method for string.
	 * 
	 * @param string
	 *            the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

}
