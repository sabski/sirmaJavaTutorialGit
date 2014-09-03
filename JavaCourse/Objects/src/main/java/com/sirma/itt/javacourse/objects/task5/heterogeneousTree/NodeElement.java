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
	private List<NodeElement<T>> children;
	private NodeElement<T> parent;

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
		this.children = new ArrayList<NodeElement<T>>();
	}

	/**
	 * Parent constructor.
	 * 
	 * @param object
	 *            the value that is contained in the node.
	 * @param parent
	 *            parent of the current node
	 */
	public NodeElement(Figure object, NodeElement<T> parent) {
		this.object = object;
		this.parent = parent;
		this.children = new ArrayList<NodeElement<T>>();
	}

	/**
	 * Empty node constructor.
	 */
	public NodeElement() {
		super();
	}

	/**
	 * Getter method for children.
	 * 
	 * @return the children
	 */
	public List<NodeElement<T>> getChildren() {
		return children;
	}

	/**
	 * Setter method for children.
	 * 
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<NodeElement<T>> childred) {
		this.children = childred;
	}

	/**
	 * Getter method for parent.
	 * 
	 * @return the parent
	 */
	public NodeElement<T> getParent() {
		return parent;
	}

	/**
	 * Setter method for parent.
	 * 
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(NodeElement<T> parent) {
		this.parent = parent;
	}

}
