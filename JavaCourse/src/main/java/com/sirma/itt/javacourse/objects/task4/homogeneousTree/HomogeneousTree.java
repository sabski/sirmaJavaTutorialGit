package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;

/**
 * This class represent a generic type collection that extend Figure.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class HomogeneousTree<T extends Figure> {

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
	 */
	public void printAllNames() {
		printElementNode(rootEllement);
	}

	/**
	 * Prints in the console the elements name and that of its children.
	 * 
	 * @param node
	 *            the node element to be printed
	 */
	private void printElementNode(NodeElement<T> node) {
		System.out.println(node.getObject().getName());
		if (node.getLeft() != null) {
			printElementNode(node.getLeft());
		}
		if (node.getRight() != null) {
			printElementNode(node.getRight());
		}
	}

	/**
	 * Adds an element to the tree.
	 * 
	 * @param element
	 *            the element to be added to the tree.
	 */
	public void addElement(NodeElement<T> element) {

		System.out.println(insertNode(rootEllement, element));
	}

	/**
	 * Add directly a figure element to the tree.
	 * 
	 * @param f
	 *            the Figure we are adding
	 */
	public void addFigureEllemet(Figure f) {
		NodeElement<T> node = new NodeElement<T>(f);
		addElement(node);
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
		if (treeNode.equals(nodeTobeInserted)) {
			return false;
		}
		if (treeNode.hashCode() > nodeTobeInserted.hashCode()) {
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
