package com.sirma.itt.javacourse.objects.task2.shapes.circularShapes;

import com.sirma.itt.javacourse.objects.task2.shapes.Point;

/**
 * Class for drawing Circle Shapes.
 * 
 * @author simeon
 */
public class Circle extends Point {

	private int radius;

	/**
	 * Getter method for radius.
	 * 
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Setter method for radius.
	 * 
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	

	/**
	 * Constructor with center point and radius.
	 * 
	 * @param p
	 *            center point of the circle.
	 * @param radius
	 *            the radius of the circle.
	 */
	public Circle(Point p, int radius) {
		super(p.getX(), p.getY());
		this.radius = radius;
		setName("Circle");
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
