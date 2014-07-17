package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

/**
 * Class that represents a node element in a heterogeneous tree.
 * 
 * @param <T>
 *            generic type parameter.
 * @author simeon
 */
public class TreeElement<T> {

	private T element;
	private TreeElement<T> left;
	private TreeElement<T> right;

	
	/**
	 * Getter method for element.
	 *
	 * @return the element
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Setter method for element.
	 *
	 * @param element the element to set
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * Getter method for left.
	 * 
	 * @return the left
	 */
	public TreeElement<T> getLeft() {
		return left;
	}

	/**
	 * Setter method for left.
	 * 
	 * @param left
	 *            the left to set
	 */
	public void setLeft(TreeElement<T> left) {
		this.left = left;
	}

	/**
	 * Getter method for right.
	 * 
	 * @return the right
	 */
	public TreeElement<T> getRight() {
		return right;
	}

	/**
	 * Setter method for right.
	 * 
	 * @param right
	 *            the right to set
	 */
	public void setRight(TreeElement<T> right) {
		this.right = right;
	}

}
