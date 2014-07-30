package com.sirma.itt.javacourse.objects.task2.shapes;

/**
 * Class for drawing point objects.
 * 
 * @author simeon
 */
public class Point extends Figure {

	private int x;
	private int y;

	/**
	 * Getter method for x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for x.
	 * 
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter method for y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for y.
	 * 
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Constructor for the class Point.
	 * 
	 * @param x
	 *            the x-coordinates of the point.
	 * @param y
	 *            the y-coordinates of the point.
	 */
	public Point(int x, int y) {
		super("Point");
		this.x = x;
		this.y = y;
	}

	/**
	 * {@inheritDoc} Draws the specific shape.
	 */
	@Override
	public void draw() {
		// TODO Write draw code.....

	}
}
