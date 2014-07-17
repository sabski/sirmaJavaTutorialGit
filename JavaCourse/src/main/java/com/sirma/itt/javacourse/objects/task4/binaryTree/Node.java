package com.sirma.itt.javacourse.objects.task4.binaryTree;

import java.util.ArrayList;

/**
 * A node for that represents a tree element in a binary tree.
 * 
 * @author simeon
 */
public class Node {

	private Integer value = null;
	private Node left;
	private Node right;

	/**
	 * Getter method for value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Setter method for value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Getter method for left.
	 * 
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Setter method for left.
	 * 
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Getter method for rigth.
	 * 
	 * @return the rigth
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Setter method for right.
	 * 
	 * @param rigth
	 *            the right to set
	 */
	public void setRight(Node rigth) {
		this.right = rigth;
	}

	/**
	 * @param value
	 *            the Integer value of the node.
	 */
	public Node(int value) {
		super();
		this.value = value;
	}

	/**
	 * Insert value into node.
	 * 
	 * @param val
	 *            the value to be inserted into the node.
	 */
	public void insertIntoNode(int val) {
		if (value == null) {
			value = val;
			System.out.println("Inserted value ");
		} else if (val == value) {
			System.out.println("Value is already in tree");
		} else if (val > value) {
			if (right == null) {
				right = new Node();
			}
			right.insertIntoNode(val);
		} else {
			if (left == null) {
				left = new Node();
			}
			left.insertIntoNode(val);
		}
	}

	/**
	 * Empty object constructor.
	 */
	public Node() {
		super();
	}

	/**
	 * Returns the elements in the current node and its child elements.
	 * 
	 * @return arrayList with node child values and the values it holds.
	 */
	public ArrayList<Integer> returnNodeElements() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (left != null) {
			result.addAll(left.returnNodeElements());
		}
		result.add(value);
		if (right != null) {
			result.addAll(right.returnNodeElements());
		}
		return result;
	}

	/**
	 * Searches the node for a specific value.
	 * 
	 * @param node
	 *            the node to be searched.
	 * @param val
	 *            the value that we are looking for.
	 * @return true if element is found
	 */
	public boolean searchNodes(Node node, int val) {
		int temp = node.getValue();
		if (temp == val) {
			System.out.println("Value is in the tree");
			return true;
		} else if (val > temp) {
			if (node.getRight() != null) {
				return searchNodes(node.getRight(), val);
			} else {
				System.out.println("No such value");
				return false;
			}
		} else {
			if (node.getLeft() != null) {
				return searchNodes(node.getLeft(), val);
			} else {
				System.out.println("No such value");
				return false;
			}
		}
	}
}
