package com.sirma.itt.javacourse.objects.task2.shapes;

/**
 * Abstract figure class for different shape objects.
 * 
 * @author simeon
 */
public abstract class Figure {

	private String name;

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method for visualizing different shapes.
	 */
	public abstract void draw();

	/**
	 * Basic constructor.
	 * 
	 * @param name
	 *            the name of the figure
	 */
	public Figure(String name) {
		this.name = name;
	}
}
