package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Child class that has a weight of 4.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 4)
public class ChildCClass extends ParrentClass {

	private double doubleValue = Math.PI;

	private String stringValue = "";

	/**
	 * Getter method for doubleValue.
	 * 
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * Setter method for doubleValue.
	 * 
	 * @param doubleValue
	 *            the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
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

	/**
	 * @param id
	 *            the id of the object.
	 * @param doubleValue
	 *            a double value for the object
	 * @param stringValue
	 *            some String
	 */
	public ChildCClass(int id, double doubleValue, String stringValue) {
		super(id);
		this.doubleValue = doubleValue;
		this.stringValue = stringValue;
	}

}
