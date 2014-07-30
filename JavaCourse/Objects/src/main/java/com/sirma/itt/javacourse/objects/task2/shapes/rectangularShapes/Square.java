package com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing Square type objects.
 * 
 * @author simeon
 */
public class Square extends Figure {

	private int sideA;
	private Point firstPoint;

	/**
	 * Getter method for side.
	 * 
	 * @return the side
	 */
	public int getSideA() {
		return sideA;
	}

	/**
	 * Setter method for side.
	 * 
	 * @param side
	 *            the side to set
	 */
	public void setSideA(int side) {
		this.sideA = side;
	}

	/**
	 * Point constructor.
	 * 
	 * @param firstPoint
	 *            top left point of the rectangle * @param secondPoint           
	 * @param side
	 *            the side of the square
	 */
	public Square(Point firstPoint, int side) {
		super("Square");
		this.sideA = side;
		this.firstPoint = firstPoint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw a square
	}

}
