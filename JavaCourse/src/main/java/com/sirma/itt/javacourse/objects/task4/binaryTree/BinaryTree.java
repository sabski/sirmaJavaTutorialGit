package com.sirma.itt.javacourse.objects.task4.binaryTree;

import java.util.ArrayList;

import com.sirma.itt.javacourse.intro.task4.arraySorting.QuickSortImpl;

/**
 * Class that represents binary tree structure.
 * 
 * @author simeon
 */
public class BinaryTree {

	private Node rootNode;

	/**
	 * Getter method for rootNode.
	 * 
	 * @return the rootNode
	 */
	public Node getRootNode() {
		return rootNode;
	}

	/**
	 * Setter method for rootNode.
	 * 
	 * @param rootNode
	 *            the rootNode to set
	 */
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * Prints the elements in the tree in a sorted way.
	 * 
	 * @return the sorted array
	 */
	public ArrayList<Integer> printSortedElements() {
		ArrayList<Integer> result = rootNode.returnNodeElements();
		// System.out.println("Array before sorting" + result.toString());
		// result = QuickSortImpl.quickSortArray(result);
		System.out.println("Sorted Array " + result.toString());
		return result;
	}

	/**
	 * Inserts a value into the tree starting from the top.
	 * 
	 * @param val
	 *            value to be inserted.
	 * @return true if insert was successful.
	 */
	public boolean insertIntoTree(int val) {
		Node nodeToBeInserted = new Node(val);
		return insertIntoTree(rootNode, nodeToBeInserted);
	}

	/**
	 * Inserts a value into a specific node.
	 * 
	 * @param treeNode
	 *            the node to check if the value can be inserted.
	 * @param nodeToBeInserted
	 *            value to be inserted.
	 * @return true if the element was inserted in the tree.
	 */
	private boolean insertIntoTree(Node treeNode, Node nodeToBeInserted) {
		if (treeNode.equals(nodeToBeInserted)) {
			return false;
		}
		if (treeNode.getValue() > nodeToBeInserted.getValue()) {
			if (treeNode.getLeft() != null) {
				return insertIntoTree(treeNode.getLeft(), nodeToBeInserted);

			} else {
				treeNode.setLeft(nodeToBeInserted);
				return true;
			}
		} else {
			if (treeNode.getRight() != null) {
				return insertIntoTree(treeNode.getRight(), nodeToBeInserted);
			} else {
				treeNode.setRight(nodeToBeInserted);
				return true;
			}
		}
	}

	/**
	 * Searches the tree.
	 * 
	 * @param val
	 *            value we are looking for
	 * @return true if element is in the tree
	 */
	public boolean searchTree(int val) {
		return rootNode.searchNodes(rootNode, val);
	}
}
