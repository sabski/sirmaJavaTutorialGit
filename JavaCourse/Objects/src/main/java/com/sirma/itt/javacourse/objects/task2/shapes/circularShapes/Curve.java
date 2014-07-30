package com.sirma.itt.javacourse.objects.task2.shapes.circularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing curves.
 * 
 * @author simeon
 */
public class Curve extends Figure {

	private int alpha;
	private Point a;
	private Point b;

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
	 * Getter method for a.
	 * 
	 * @return the a
	 */
	public Point getA() {
		return a;
	}

	/**
	 * Setter method for a.
	 * 
	 * @param a
	 *            the a to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * Getter method for b.
	 * 
	 * @return the b
	 */
	public Point getB() {
		return b;
	}

	/**
	 * Setter method for b.
	 * 
	 * @param b
	 *            the b to set
	 */
	public void setB(Point b) {
		this.b = b;
	}

	/**
	 * Default constructor for curve object with alpha = 30.
	 * 
	 * @param a
	 *            the first point of the curve
	 * @param b
	 *            the second point of the curve
	 * @param alpha
	 *            the degrees of the curve
	 */
	public Curve(Point a, Point b, int alpha) {
		super("Curve");
		this.alpha = 30;
		this.a = a;
		this.b = b;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw ....

	}

}
