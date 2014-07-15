package com.sirma.itt.javacourse.objects.task2.shapes.polyline;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Segment class AKA Line.
 * 
 * @author simeon
 */
public class Segment extends Figure {

	private Point a;
	private Point b;

	/**
	 * Constructor for segment.
	 * 
	 * @param a
	 *            the first point
	 * @param b
	 *            the second point
	 */
	public Segment(Point a, Point b) {
		super("Segment");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Draw a line

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

}
