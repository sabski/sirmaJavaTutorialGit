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
	 */
	public void printSortedElements() {
		ArrayList<Integer> result = rootNode.returnNodeElements();
		// System.out.println("Array before sorting" + result.toString());
		result = QuickSortImpl.quickSortArray(result);
		System.out.println(result.toString());
	}

	/**
	 * Inserts a value into the tree starting from the top.
	 * 
	 * @param val
	 *            value to be inserted.
	 */
	public void insertIntoTree(int val) {
		insertIntoTree(rootNode, val);
	}

	/**
	 * Inserts a value into a specific node.
	 * 
	 * @param node
	 *            the node to check if the value can be inserted.
	 * @param val
	 *            value to be inserted.
	 */
	private void insertIntoTree(Node node, int val) {
		if (node == null) {
			Node temp = new Node();
			temp.setValue(val);
			System.out.println("Value inserted");
		} else if (node.getValue() == val) {
			System.out.println("Value is alredy a tree element" + val);
		} else if (node.getValue() > val) {

		} else {

		}
	}

	/**
	 * Searches the tree.
	 * 
	 * @param val
	 *            value we are looking for
	 */
	public void searchTree(int val) {
		rootNode.searchNodes(rootNode, val);
	}
}
