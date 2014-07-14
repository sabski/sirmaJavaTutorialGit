package com.sirma.itt.javacourse.objects.task2.shapes.circularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing curves.
 * 
 * @author simeon
 */
public class Curve extends Ellipse {

	private int alpha;

	/**
	 * Getter method for alpha.
	 * 
	 * @return the alpha
	 */
	public int getAlpha() {
		return alpha;
	}

	/**
	 * Setter method for alpha.
	 * 
	 * @param alpha
	 *            the alpha to set
	 */
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	/**
	 * Default constructor for curve object with alpha = 30.
	 * 
	 * @param a
	 *            the first point of the curve
	 * @param b
	 *            the second point of the curve
	 */
	public Curve(Point a, Point b) {
		super(a, b.getX(), b.getY());
		this.alpha = 30;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw ....

	}

}
