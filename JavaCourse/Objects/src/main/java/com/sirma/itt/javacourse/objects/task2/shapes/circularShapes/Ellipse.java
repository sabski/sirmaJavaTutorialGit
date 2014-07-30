package com.sirma.itt.javacourse.objects.task2.shapes.circularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing ellipse type objects.
 * 
 * @author simeon
 */
public class Ellipse extends Circle {

	private int secondRadius;

	/**
	 * Getter method for secondRadius.
	 * 
	 * @return the secondRadius
	 */
	public int getSecondRadius() {
		return secondRadius;
	}

	/**
	 * Setter method for secondRadius.
	 * 
	 * @param secondRadius
	 *            the secondRadius to set
	 */
	public void setSecondRadius(int secondRadius) {
		this.secondRadius = secondRadius;
	}

	/**
	 * Constructor for an ellipse object.
	 * 
	 * @param p
	 *            the center point of the ellipse.
	 * @param radius
	 *            the first radius of the object.
	 * @param secondRadius
	 *            the second radius of the object.
	 */
	public Ellipse(Point p, int radius, int secondRadius) {
		super(p, radius);
		this.secondRadius = secondRadius;
		setName("Ellipse");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
	}

}
