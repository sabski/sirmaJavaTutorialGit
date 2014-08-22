package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sirma.itt.javacourse.Utils;

/**
 * @param <V>
 * @param <K>
 * @author simeon
 */
public class LRUMapCache<V, K> {

	private Map<K, V> cacheMap;
	private Map<K, Integer> hitMap;
	private int maxObjects;

	public boolean addCacheEllement(K key, V o) {
		if (cacheMap.containsKey(key)) {
			ellementHit(key);
			Utils.printConsoleMessage("Hit");
			return false;
		} else if (maxObjects > cacheMap.size()) {
			cacheMap.put(key, o);
			hitMap.put(key, 0);
			return true;
		} else {
			Utils.printConsoleMessage("Miss");
			int min = Integer.MAX_VALUE;
			K searchedKey = null;
			for (K i : hitMap.keySet()) {
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

	private void ellementHit(K key) {
		int i = hitMap.get(key);
		i++;
		hitMap.put(key, i);
	}

	public Collection<V> getAllEllements() {
		return cacheMap.values();
	}

	public V getEllementByKey(K key) {
		ellementHit(key);
		return cacheMap.get(key);
	}

	/**
	 * @param maxObjects
	 */
	public LRUMapCache(int maxObjects) {
		this.maxObjects = maxObjects;
		cacheMap = new HashMap<K, V>(maxObjects);
		hitMap = new HashMap<K, Integer>();
	}

}
