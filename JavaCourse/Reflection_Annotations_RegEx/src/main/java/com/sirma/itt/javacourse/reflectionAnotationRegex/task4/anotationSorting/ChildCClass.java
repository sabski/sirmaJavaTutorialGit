package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Child class that has a weight of 4.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 4)
public class ChildCClass extends ParrentClass {

	private float pi = 3.14f;

	/**
	 * Getter method for pi.
	 * 
	 * @return the pi
	 */
	public float getPi() {
		return pi;
	}

	/**
	 * Setter method for pi.
	 * 
	 * @param pi
	 *            the pi to set
	 */
	public void setPi(float pi) {
		this.pi = pi;
	}

}
