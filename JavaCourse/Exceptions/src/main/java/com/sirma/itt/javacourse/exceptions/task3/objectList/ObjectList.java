package com.sirma.itt.javacourse.exceptions.task3.objectList;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class that represents a list of items
 * 
 * @author simeon
 */
public class ObjectList {

	private int capacity = 10;
	private int index = 0;

	private Object[] array;

	/**
	 * @param capacity
	 *            the capacity of the array.
	 */
	public ObjectList(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
	}

	/**
	 * Basic constructor for object list.
	 */
	public ObjectList() {
		super();
		array = new Object[capacity];
	}

	/**
	 * Adds an element at the last available index.
	 * 
	 * @param obj
	 *            the object to be added.
	 * @return true if the insert was successful.
	 */
	public boolean addElement(Object obj) {
		if (index > capacity - 1) {
			throw new OverFlodException();
		} else {
			array[index] = obj;
			index++;
			return true;
		}

	}

	/**
	 * Removes the last element of the array;
	 */
	public boolean removeElement() {
		index--;
		if (index < 0) {
			// Reset index value to Zero.
			index = 0;
			throw new NegativeIndexException();
		}
		array[index] = null;
		return true;
	}

	/**
	 * Removes an object at a specific index.
	 * 
	 * @param index
	 *            the index of the object to be removed in the array.
	 * @return true if the remove was successful.
	 */
	public boolean removeElementAtIndex(int index) {
		if (index < 0 || index > this.index) {
			throw new NegativeIndexException();
		}
		array[index] = null;
		return true;
	}

	/**
	 * Removes a specific object in the array.
	 * 
	 * @param obj
	 *            the object to be removed from the array.
	 * @return true if the object was found in the array.
	 */
	public boolean removeElementByObject(Object obj) {
		for (int i = 0; i < array.length; i++) {
			Object arrObj = array[i];
			if (arrObj != null && arrObj.equals(obj)) {
				array[i] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints all the current elements in the array.
	 */
	public void printAllElements() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < index; i++) {
			builder.append(" " + array[i]);
		}
		builder.append(" ]");
		InputUtils.printConsoleMessage(builder.toString());
	}
}
