package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

/**
 * Parent class with base value of the annotation.
 * 
 * @author simeon
 */
@SortingAnotation(weight = 1)
public class ParrentClass implements Comparable<ParrentClass> {

	private int id = 1;

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(ParrentClass parent) {
		if (this.id > parent.getId()) {
			return 1;
		} else if (parent.getId() > this.id) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "ID : " + id;
	}

	/**
	 * @param id
	 *            the id of the element.
	 */
	public ParrentClass(int id) {
		this.id = id;
	}
}
