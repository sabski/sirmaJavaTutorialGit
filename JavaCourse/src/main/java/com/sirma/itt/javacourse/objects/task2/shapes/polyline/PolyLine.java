package com.sirma.itt.javacourse.objects.task2.shapes.polyline;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.circularShapes.Curve;

/**
 * Class for drawing a poly line element.
 * 
 * @author simeon
 */
public class PolyLine extends Figure {

	private Curve[] curves;

	private Segment[] segments;

	/**
	 * Getter method for curves.
	 *
	 * @return the curves
	 */
	public Curve[] getCurves() {
		return curves;
	}

	/**
	 * Setter method for curves.
	 *
	 * @param curves the curves to set
	 */
	public void setCurves(Curve[] curves) {
		this.curves = curves;
	}

	/**
	 * Getter method for segments.
	 *
	 * @return the segments
	 */
	public Segment[] getSegments() {
		return segments;
	}

	/**
	 * Setter method for segments.
	 *
	 * @param segments the segments to set
	 */
	public void setSegments(Segment[] segments) {
		this.segments = segments;
	}

	/**
	 * Constructor that accepts curves.
	 * 
	 * @param curves
	 *            the curves for the poly line.
	 */
	public PolyLine(Curve... curves) {
		super("PolyLine");
		this.curves = curves;
	}

	/**
	 * Constructor with segments.
	 * 
	 * @param segment
	 *            for the polyline
	 */
	public PolyLine(Segment... segment) {
		super("PolyLine");
		this.segments = segment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		// TODO Draw the poly line...

	}

}
