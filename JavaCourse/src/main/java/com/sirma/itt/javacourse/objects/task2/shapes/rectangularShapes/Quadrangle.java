package com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * @author simeon
 */
public class Quadrangle extends Figure {

	private Point one;
	private Point two;
	private Point three;
	private Point four;

	/**
	 * Getter method for one.
	 * 
	 * @return the one
	 */
	public Point getOne() {
		return one;
	}

	/**
	 * Setter method for one.
	 * 
	 * @param one
	 *            the one to set
	 */
	public void setOne(Point one) {
		this.one = one;
	}

	/**
	 * Getter method for two.
	 * 
	 * @return the two
	 */
	public Point getTwo() {
		return two;
	}

	/**
	 * Setter method for two.
	 * 
	 * @param two
	 *            the two to set
	 */
	public void setTwo(Point two) {
		this.two = two;
	}

	/**
	 * Getter method for three.
	 * 
	 * @return the three
	 */
	public Point getThree() {
		return three;
	}

	/**
	 * Setter method for three.
	 * 
	 * @param three
	 *            the three to set
	 */
	public void setThree(Point three) {
		this.three = three;
	}

	/**
	 * Getter method for four.
	 * 
	 * @return the four
	 */
	public Point getFour() {
		return four;
	}

	/**
	 * Setter method for four.
	 * 
	 * @param four
	 *            the four to set
	 */
	public void setFour(Point four) {
		this.four = four;
	}

	/**
	 * Constructor for Quadrangle.
	 * 
	 * @param one
	 *            the first point of the Quadrangle
	 * @param two
	 *            the second point of the Quadrangle
	 * @param three
	 *            the third point of the Quadrangle
	 * @param four
	 *            the fourth point of the Quadrangle
	 */
	public Quadrangle(Point one, Point two, Point three, Point four) {
		super("Quadrangle");
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
