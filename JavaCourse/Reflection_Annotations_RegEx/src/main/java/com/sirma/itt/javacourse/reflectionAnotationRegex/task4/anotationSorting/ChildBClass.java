package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Simple class only used to test annotation sorting.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 3)
public class ChildBClass extends ParrentClass{

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
