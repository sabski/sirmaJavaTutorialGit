package com.sirma.itt.javacourse.objects.task5.heterogeneousTree;

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
	private NodeElement<T> right;
	private NodeElement<T> left;

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
	 * Getter method for right.
	 * 
	 * @return the right
	 */
	public NodeElement<T> getRight() {
		return right;
	}

	/**
	 * Setter method for right.
	 * 
	 * @param rigth
	 *            the right to set
	 */
	public void setRight(NodeElement<T> rigth) {
		this.right = rigth;
	}

	/**
	 * Getter method for left.
	 * 
	 * @return the left
	 */
	public NodeElement<T> getLeft() {
		return left;
	}

	/**
	 * Setter method for left.
	 * 
	 * @param left
	 *            the left to set
	 */
	public void setLeft(NodeElement<T> left) {
		this.left = left;
	}

	/**
	 * @param object
	 *            The figure based object.
	 */
	public NodeElement(Figure object) {
		super();
		this.object = object;
	}

	/**
	 * Empty node constructor.
	 */
	public NodeElement() {
		super();
	}

}
