package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that implement the LRU(Least Recently Used) buffer algorithm.
 * 
 * @author simeon
 */
public class LRUCache {

	private List<Object> lruStack;
	private int pointer;
	private List<Integer> history;
	private int maxObjects;

	/**
	 * Getter method for maxObjects.
	 * 
	 * @return the maxObjects
	 */
	public int getMaxObjects() {
		return maxObjects;
	}

	/**
	 * Setter method for maxObjects.
	 * 
	 * @param maxObjects
	 *            the maxObjects to set
	 */
	public void setMaxObjects(int maxObjects) {
		this.maxObjects = maxObjects;
	}

	/**
	 * @param maxObjects
	 */
	public LRUCache(int maxObjects) {
		this.maxObjects = maxObjects;
		pointer = 0;
		lruStack = new ArrayList<Object>();
		history = new ArrayList<Integer>();
	}

	public boolean addCacheElement(Object o) {

		if (lruStack.contains(o)) {
			Integer tmp = lruStack.indexOf(o);
			history.remove(tmp);
			history.add(0, tmp);
			return false;
		} else {
			if (history.size() == 0) {
				pointer = 0;
			} else if (maxObjects > history.size()) {
				pointer++;
			} else {
				pointer = getLastIndex();
				lruStack.remove(pointer);
				history.remove(history.size() - 1);
			}
			history.add(0, pointer);
			lruStack.add(pointer, o);
			return true;
		}
	}

	private Integer getLastIndex() {
		IOUtils.printConsoleMessage("History :" + history.get(history.size() - 1));
		return history.get(history.size() - 1);
	}

	public Object getElement(Object o) {

		return o;
	}

	public Collection<Object> getAllEllements() {
		return lruStack;
	}
}
