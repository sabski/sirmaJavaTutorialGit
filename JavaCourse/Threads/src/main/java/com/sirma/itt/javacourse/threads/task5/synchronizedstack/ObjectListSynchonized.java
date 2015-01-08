package com.sirma.itt.javacourse.threads.task5.synchronizedstack;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class that represents a list of items.
 * 
 * @author Simeon Iliev
 */
public class ObjectListSynchonized {

	private static final Logger LOGGER = Logger.getLogger(ObjectListSynchonized.class);
	private int capacity = 10;
	private int index = 0;
	private boolean addFlag = true;
	private boolean removeFlag = false;
	private Object[] array;

	/**
	 * @param capacity
	 *            the capacity of the array.
	 */
	public ObjectListSynchonized(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
	}

	/**
	 * Basic constructor for object list.
	 */
	public ObjectListSynchonized() {
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
	public synchronized boolean addElement(Object obj) {
		array[index] = obj;
		index++;
		if (index > capacity - 1) {
			// Set addFlag to false here...
			setAddFlag(false);
		}
		setRemoveFlag(true);
		return true;

	}

	/**
	 * Removes the last element of the array.
	 * 
	 * @return true if the remove was successful
	 */
	public synchronized boolean removeElement() {
		index--;
		LOGGER.info("Removing element at index " + index);
		setAddFlag(true);
		array[index] = null;
		if (index <= 0) {
			// Reset index value to Zero.
			index = 0;
			// Set remove flag to false here...
			setRemoveFlag(false);
		}
		return true;
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

	/**
	 * Getter method for addFlag.
	 * 
	 * @return the addFlag
	 */
	public boolean isAddFlag() {
		return addFlag;
	}

	/**
	 * Setter method for addFlag.
	 * 
	 * @param addFlag
	 *            the addFlag to set
	 */
	public void setAddFlag(boolean flag) {
		this.addFlag = flag;
	}

	/**
	 * Getter method for removeFlag.
	 * 
	 * @return the removeFlag
	 */
	public boolean isRemoveFlag() {
		return removeFlag;
	}

	/**
	 * Setter method for removeFlag.
	 * 
	 * @param canRemove
	 *            the canRemove to set
	 */
	public void setRemoveFlag(boolean canRemove) {
		this.removeFlag = canRemove;
	}

}
