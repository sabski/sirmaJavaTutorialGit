package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.apache.log4j.Logger;

/**
 * LRU implementation class.
 * 
 * @param <K>
 *            the key value for the objects.
 * @param <V>
 *            the Object type value that is to be stored in the cache.
 * @author simeon
 */
public class LRUTailCache<K, V> {

	private final Logger log = Logger.getLogger(LRUTailCache.class);
	private final Map<K, V> cache;
	private final Queue<K> queue;
	private final int maxElementts;

	/**
	 * Constructor for LRUTailCache class.
	 * 
	 * @param maxElementts
	 *            the maximum number of elements allowed in the cache
	 */
	public LRUTailCache(int maxElementts) {
		this.maxElementts = maxElementts;
		cache = new HashMap<K, V>(maxElementts);
		queue = new LinkedList<K>();
	}

	/**
	 * Adds an element to the cache. First we check if the element is in the cache if it it is we
	 * hit it, otherwise we check the size of the cache if its full or not, if the cache is not full
	 * we directly input the element in it. When the cache is full we use the queue to get the last
	 * visited element and replace it with the new element and also we place the new element in the
	 * queue.
	 * 
	 * @param key
	 *            the key for the object that is to placed in the map.
	 * @param value
	 *            the value of the object.
	 * @return true if the object was added to the cache, false otherwise.
	 */
	public boolean addElement(K key, V value) {
		if (cache.containsKey(key)) {
			hitElement(key);
			log.info("Hit");
			return false;
		} else if (maxElementts > cache.size()) {
			insertElement(key, value);
			log.info("Miss");
			return true;
		} else {
			removeElementByKey(queue.peek());
			insertElement(key, value);
			log.info("Miss");
			return true;
		}
	}

	/**
	 * Inserts element in the cache and the queue.
	 * 
	 * @param key
	 *            the key to the object;
	 * @param value
	 *            the value of the object;
	 */
	private void insertElement(K key, V value) {
		cache.put(key, value);
		queue.add(key);
	}

	/**
	 * Retrieves an element of the cache by specific key if there is no object to be found it
	 * returns null.
	 * 
	 * @param key
	 *            the key of the object.
	 * @return the object which is associated with the key, if there is no object with the specific
	 *         key or @return null.
	 */
	public V getElement(K key) {
		if (cache.containsKey(key)) {
			hitElement(key);
		}
		return cache.get(key);
	}

	/**
	 * Removes an element from the cache by its key, if there is no key that matches returns false.
	 * 
	 * @param key
	 *            the key to the object we want to remove.
	 * @return true if the object was removed otherwise returns false.
	 */
	public boolean removeElementByKey(K key) {
		if (cache.containsKey(key)) {
			cache.remove(key);
			queue.remove(key);
			return true;
		}
		return false;
	}

	/**
	 * Hits the queue that an object was used.
	 * 
	 * @param key
	 *            the key of the object.
	 */
	private void hitElement(K key) {
		queue.remove(key);
		queue.add(key);
	}

	/**
	 * Returns a collection of all the elements in the cache.
	 * 
	 * @return a collection of all the elements in the cache.
	 */
	public Collection<V> getAllElements() {
		return cache.values();
	}
}
