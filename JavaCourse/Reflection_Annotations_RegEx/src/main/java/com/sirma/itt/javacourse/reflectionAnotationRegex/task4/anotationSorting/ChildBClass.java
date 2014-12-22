package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Simple class only used to test annotation sorting.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 3)
public class ChildBClass extends ParrentClass {

	private float floatValue = (float) Math.PI;

	private String stringValue = "";

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
	 * @param id
	 *            of the object.
	 * @param floatValue
	 *            float value.
	 * @param strngValue
	 *            some string value
	 */
	public ChildBClass(int id, float floatValue, String strngValue) {
		super(id);
		this.floatValue = floatValue;
		this.setStringValue(strngValue);
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
}
