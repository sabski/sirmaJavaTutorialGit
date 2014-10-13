package com.sirma.itt.javacourse.threads.task5.synchronizedStack;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that represents a list of items.
 * 
 * @author Simeon Iliev
 */
public class ObjectListSynchonized {

	private Logger log = Logger.getLogger(ObjectListSynchonized.class);
	private int capacity = 10;
	private int index = 0;
	private boolean canAdd = true;
	private boolean canRemevo = false;
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
			// Set canAdd to false here...
			setCanAdd(false);
		}
		setCanRemevo(true);
		return true;

	}

	/**
	 * Removes the last element of the array.
	 * 
	 * @return true if the remove was succesful
	 */
	public synchronized boolean removeElement() {
		index--;
		log.info("Removing element at index " + index);
		setCanAdd(true);
		array[index] = null;
		if (index <= 0) {
			// Reset index value to Zero.
			index = 0;
			// Set canAdd to true here...
			setCanRemevo(false);
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
		IOUtils.printConsoleMessage(builder.toString());
	}

	/**
	 * Getter method for canAdd.
	 * 
	 * @return the canAdd
	 */
	public boolean isCanAdd() {
		return canAdd;
	}

	/**
	 * Setter method for canAdd.
	 * 
	 * @param canAdd
	 *            the canAdd to set
	 */
	public void setCanAdd(boolean flag) {
		this.canAdd = flag;
	}

	/**
	 * Getter method for canRemevo.
	 * 
	 * @return the canRemevo
	 */
	public boolean isCanRemevo() {
		return canRemevo;
	}

	/**
	 * Setter method for canRemevo.
	 * 
	 * @param canRemevo
	 *            the canRemevo to set
	 */
	public void setCanRemevo(boolean canRemevo) {
		this.canRemevo = canRemevo;
	}

}
