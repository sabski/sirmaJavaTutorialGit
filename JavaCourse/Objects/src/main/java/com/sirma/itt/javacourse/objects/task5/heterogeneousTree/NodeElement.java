package com.sirma.itt.javacourse.objects.task5.heterogeneousTree;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;

/**
 * Class that is user to represent node elements in a HomogeneousTree.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class NodeElement<T extends Figure> {

	private Figure object;
	private List<NodeElement<T>> childred;

	/**
	 * Getter method for object.
	 * 
	 * @return the object
	 */
	public Figure getObject() {
		return object;
	}

	/**
	 * Setter method for object.
	 * 
	 * @param object
	 *            the object to set
	 */
	public void setObject(Figure object) {
		this.object = object;
	}

	/**
	 * Basic constructor for node objects.
	 * 
	 * @param object
	 *            The figure based object.
	 */
	public NodeElement(Figure object) {
		super();
		this.object = object;
		this.childred = new ArrayList<NodeElement<T>>();
	}

	/**
	 * Empty node constructor.
	 */
	public NodeElement() {
		super();
	}

	/**
	 * Getter method for childred.
	 * 
	 * @return the childred
	 */
	public List<NodeElement<T>> getChildred() {
		return childred;
	}

	/**
	 * Setter method for childred.
	 * 
	 * @param childred
	 *            the childred to set
	 */
	public void setChildred(List<NodeElement<T>> childred) {
		this.childred = childred;
	}

}
