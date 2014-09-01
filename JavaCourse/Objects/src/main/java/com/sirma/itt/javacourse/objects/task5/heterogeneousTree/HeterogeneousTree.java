package com.sirma.itt.javacourse.objects.task5.heterogeneousTree;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;

/**
 * This class represent a generic type collection that extend Figure.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class HeterogeneousTree<T extends Figure> {

	private NodeElement<T> rootEllement;

	/**
	 * Getter method for rootEllement.
	 * 
	 * @return the rootEllement
	 */
	public NodeElement<T> getRootEllement() {
		return rootEllement;
	}

	/**
	 * Setter method for rootEllement.
	 * 
	 * @param rootEllement
	 *            the rootEllement to set
	 */
	public void setRootEllement(NodeElement<T> rootEllement) {
		this.rootEllement = rootEllement;
	}

	/**
	 * Prints all the element names.
	 * 
	 * @return The name of the objects in the tree.
	 */
	public String printAllNames() {
		return printElementNode(rootEllement);
	}

	/**
	 * Prints in the console the elements name and that of its children.
	 * 
	 * @param node
	 *            the node element to be printed
	 * @return The names of the objects.
	 */
	private String printElementNode(NodeElement<T> node) {
		StringBuilder builder = new StringBuilder();

		System.out.println(node.getObject().getName());
		builder.append(node.getObject().getName());
		if (node.getLeft() != null) {
			builder.append(printElementNode(node.getLeft()));
		}
		if (node.getRight() != null) {
			builder.append(printElementNode(node.getRight()));
		}
		return builder.toString();
	}

	/**
	 * Adds an element to the tree.
	 * 
	 * @param element
	 *            the element to be added to the tree.
	 * @return true if element was inserted
	 */
	public boolean addElement(NodeElement<T> element) {

		return insertNode(rootEllement, element);
	}

	/**
	 * Add directly a figure element to the tree.
	 * 
	 * @param f
	 *            the Figure we are adding
	 * @return True if element was inserted.
	 */
	public boolean addFigureEllemet(Figure f) {
		NodeElement<T> node = new NodeElement<T>(f);
		return addElement(node);
	}

	/**
	 * Checks if a node should be inserted in the tree.
	 * 
	 * @param treeNode
	 *            an existing node from the tree.
	 * @param nodeTobeInserted
	 *            the node we want to insert.
	 * @return true if we inserted into the tree.
	 */
	private boolean insertNode(NodeElement<T> treeNode, NodeElement<T> nodeTobeInserted) {
		if (treeNode.getObject().equals(nodeTobeInserted.getObject())) {
			return false;
		}
		if (treeNode.getObject().hashCode() > nodeTobeInserted.getObject().hashCode()) {
			if (treeNode.getLeft() != null) {
				return insertNode(treeNode.getLeft(), nodeTobeInserted);

			} else {
				treeNode.setLeft(nodeTobeInserted);
				return true;
			}
		} else {
			if (treeNode.getRight() != null) {
				return insertNode(treeNode.getRight(), nodeTobeInserted);
			} else {
				treeNode.setRight(nodeTobeInserted);
				return true;
			}
		}
	}
}
