package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sirma.itt.javacourse.Utils;

/**
 * LRU Algorithm implementation that uses two maps one maps stores the values of the objects, and
 * the other is used to store the Element hit count.
 * 
 * @param <K>
 *            The key type Object that is to be used;
 * @param <V>
 *            The object type value that is to be stored in the cache;
 * @author simeon
 */
public class LRUMapCache<K, V> {

	private Map<K, V> cacheMap;
	private Map<K, Integer> hitMap;
	private int maxObjects;

	/**
	 * Adds an element to the cache. First we check if the element is in the cache if it it is we
	 * hit it, otherwise we check the size of the cache if its full or not, if the cache is not full
	 * we directly input the element in it. When the cache is full we search it to find the element
	 * with the least hit counts and place the new element in its place.
	 * 
	 * @param key
	 *            the key for the object that is to placed in the map.
	 * @param value
	 *            the value of the object.
	 * @return true if the object was added to the cache.
	 */
	public boolean addCacheEllement(K key, V value) {
		if (cacheMap.containsKey(key)) {
			elementHit(key);
			Utils.printConsoleMessage("Hit");
			return false;
		} else if (maxObjects > cacheMap.size()) {
			cacheMap.put(key, value);
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
			cacheMap.put(key, value);
			hitMap.put(key, 0);
			return true;
		}
	}

	/**
	 * Increments the hit counter of a specific element.
	 * 
	 * @param key
	 *            the key of the element that is to be incremented hit count.
	 */
	private void elementHit(K key) {
		int i = hitMap.get(key);
		i++;
		hitMap.put(key, i);
	}

	/**
	 * Returns all the elements like a basic collection interface.
	 * 
	 * @return all the elements in the map.
	 */
	public Collection<V> getAllElements() {
		return cacheMap.values();
	}

	/**
	 * Retries a object of the cache by using its key value.
	 * 
	 * @param key
	 *            the key of the object.
	 * @return the object that is in the map otherwise returns a null object if there is no key
	 *         value.
	 */
	public V getElementByKey(K key) {
		if (cacheMap.containsKey(key)) {
			elementHit(key);
		}
		return cacheMap.get(key);
	}

	/**
	 * Constructor for the LRUMapCache cache.
	 * 
	 * @param maxObjects
	 *            the Number of objects that the cache need to store this number can not be exceeded
	 *            and will remain unchanged in this cache instance;
	 */
	public LRUMapCache(int maxObjects) {
		this.maxObjects = maxObjects;
		cacheMap = new HashMap<K, V>(maxObjects);
		hitMap = new HashMap<K, Integer>();
	}

}
