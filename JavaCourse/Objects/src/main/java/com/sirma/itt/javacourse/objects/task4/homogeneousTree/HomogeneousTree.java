package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

/**
 * This class represent a generic type collection.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class HomogeneousTree<T> {

	private TreeElement<T> rootElement;

	/**
	 * Getter method for rootElement.
	 * 
	 * @return the rootElement
	 */
	public TreeElement<T> getRootElement() {
		return rootElement;
	}

	/**
	 * Setter method for rootElement.
	 * 
	 * @param rootElement
	 *            the rootElement to set
	 */
	public void setRootElement(TreeElement<T> rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * Prints all the element names.
	 * 
	 * @return printed values.
	 */
	public String printAllValues() {
		return printElementNode(rootElement);
	}

	/**
	 * Prints in the console the elements name and that of its children.
	 * 
	 * @param node
	 *            the node element to be printed
	 * @return printed values
	 */
	private String printElementNode(TreeElement<T> node) {
		StringBuilder build = new StringBuilder();
		if (node.getLeft() != null) {
			build.append(printElementNode(node.getLeft()));
		}
		build.append(node.getElement().toString());
		if (node.getRight() != null) {
			build.append(printElementNode(node.getRight()));
		}
		return build.toString();
	}

	/**
	 * Adds an element to the tree.
	 * 
	 * @param element
	 *            the element to be added to the tree.
	 * @return true if the node element was inserted
	 */
	public boolean addElement(TreeElement<T> element) {

		return insertNode(rootElement, element);
	}

	/**
	 * Add directly a figure element to the tree.
	 * 
	 * @param element
	 *            add element to the tree
	 * @return true if the T element was inserted
	 */
	public boolean addEllemet(T element) {
		TreeElement<T> node = new TreeElement<T>();
		node.setElement(element);
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
	private boolean insertNode(TreeElement<T> treeNode, TreeElement<T> nodeTobeInserted) {
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
