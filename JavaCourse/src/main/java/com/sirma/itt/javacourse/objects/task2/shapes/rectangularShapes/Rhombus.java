package com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * @author simeon
 */
public class Rhombus extends Square {

	private Point secondPoint;
	private float angleAlfa;

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
	 * Getter method for angleAlfa.
	 * 
	 * @return the angleAlfa
	 */
	public float getAngleAlfa() {
		return angleAlfa;
	}

	/**
	 * Setter method for angleAlfa.
	 * 
	 * @param angleAlfa
	 *            the angleAlfa to set
	 */
	public void setAngleAlfa(float angleAlfa) {
		this.angleAlfa = angleAlfa;
	}

	/**
	 * Constructor for a rhombus object.
	 * 
	 * @param firstPoint
	 *            the upper left point of the Rhombus
	 * @param secondPoint
	 *            the bottom right point of the Rhombus
	 * @param side
	 *            the side of the Rhombus
	 * @param angleAlfa
	 *            the angle of the side
	 */
	public Rhombus(Point firstPoint, Point secondPoint, int side, float angleAlfa) {
		super(firstPoint, side);
		this.secondPoint = secondPoint;
		this.angleAlfa = angleAlfa;
		setName("Rhombus");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw the Rhombus using some sort of formula which i haven't found yet so good luck
		// future me

	}

}
