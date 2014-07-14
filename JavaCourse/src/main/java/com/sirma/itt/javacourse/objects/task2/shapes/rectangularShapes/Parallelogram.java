package com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for displaying Parallelogram.
 * 
 * @author simeon
 */
public class Parallelogram extends Rectangle {

	private Point secondPoint;

	/**
	 * Getter method for secondPoint.
	 * 
	 * @return the secondPoint
	 */
	public Point getSecondPoint() {
		return secondPoint;
	}

	/**
	 * Setter method for secondPoint.
	 * 
	 * @param secondPoint
	 *            the secondPoint to set
	 */
	public void setSecondPoint(Point secondPoint) {
		this.secondPoint = secondPoint;
	}

	/**
	 * Constructor for Parallelogram object.
	 * 
	 * @param firstPoint
	 *            the top left point of the Parallelogram
	 * @param secondPoint
	 *            the bottom right point of the Parallelogram
	 * @param sideA
	 *            the side of the Parallelogram
	 * @param sideB
	 *            the second side of the Parallelogram
	 */
	public Parallelogram(Point firstPoint, Point secondPoint, int sideA, int sideB) {
		super(firstPoint, sideA, sideB);
		this.secondPoint = secondPoint;
		setName("Parallelogram");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw me ...
		// HINT: firstpoint, firstPoint + side
		// second point-side, second point
		// connect all the point
	}

}
