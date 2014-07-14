package com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing Rectangle shape objects.
 * 
 * @author simeon
 */
public class Rectangle extends Square {

	private int sideB;

	/**
	 * Getter method for sideB.
	 * 
	 * @return the sideB
	 */
	public int getSideB() {
		return sideB;
	}

	/**
	 * Setter method for sideB.
	 * 
	 * @param sideB
	 *            the sideB to set
	 */
	public void setSideB(int sideB) {
		this.sideB = sideB;
	}

	/**
	 * Constructor for a rectangular object.
	 * 
	 * @param p
	 *            the top left point of the rectangle;
	 * @param sideA
	 *            the vertical side of the rectangle;
	 * @param sideB
	 *            the horizontal side of the rectangle;
	 */
	public Rectangle(Point p, int sideA, int sideB) {
		super(p, sideA);
		this.sideB = sideB;
		setName("Rectangle");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw me ....
	}

}
