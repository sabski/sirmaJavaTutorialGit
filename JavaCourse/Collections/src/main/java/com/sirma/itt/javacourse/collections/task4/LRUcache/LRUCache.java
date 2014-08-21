package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sirma.itt.javacourse.Utils;

/**
 * Class that implement the LRU(Least Recently Used) buffer algorithm.
 * 
 * @author simeon
 */
public class LRUCache {

	private List<Object> lruCstack;
	private int pointer;
	private int hitCount;
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
		lruCstack = new ArrayList<Object>();
		hitCount = 0;
		history = new ArrayList<Integer>();
	}

	public boolean addCacheEllement(Object o) {

		if (lruCstack.contains(o)) {
			Integer tmp = lruCstack.indexOf(o);
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
				lruCstack.remove(pointer);
				history.remove(history.size() - 1);
			}
			history.add(0, pointer);
			lruCstack.add(pointer, o);
			return true;
		}
	}

	private Integer getLastIndex() {
		Utils.printConsoleMessage("History :" + history.get(history.size() - 1));
		return history.get(history.size() - 1);
	}

	public Object getEllement(Object o) {

		return o;
	}

	public Collection<Object> getAllEllements() {
		return lruCstack;
	}
}
