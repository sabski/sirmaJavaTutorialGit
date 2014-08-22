package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sirma.itt.javacourse.Utils;

/**
 * @author simeon
 */
public class LRUMapCache {

	private Map<Integer, Object> cacheMap;
	private Map<Integer, Integer> hitMap;
	private int maxObjects;

	public boolean addCacheEllement(Integer key, Object o) {
		if (cacheMap.containsKey(key)) {
			int i = hitMap.get(key);
			i++;
			hitMap.put(key, i);
			Utils.printConsoleMessage("Hit");
			return false;
		} else if (maxObjects > cacheMap.size()) {
			cacheMap.put(key, o);
			hitMap.put(key, 0);
			return true;
		} else {
			Utils.printConsoleMessage("Miss");
			int min = Integer.MAX_VALUE;
			int searchedKey = 0;
			for (int i : hitMap.keySet()) {
				int val = hitMap.get(i);
				if (min > val) {
					searchedKey = i;
					min = val;
				}
			}
			cacheMap.remove(searchedKey);
			hitMap.remove(searchedKey);
			cacheMap.put(key, o);
			hitMap.put(key, 0);
			return true;
		}
	}

	public Collection<Object> getAllEllements() {
		return cacheMap.values();
	}

	/**
	 * @param maxObjects
	 */
	public LRUMapCache(int maxObjects) {
		this.maxObjects = maxObjects;
		cacheMap = new HashMap<Integer, Object>(maxObjects);
		hitMap = new HashMap<Integer, Integer>(maxObjects);
	}
}
