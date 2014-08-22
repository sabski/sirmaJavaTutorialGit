package com.sirma.itt.javacourse.collections.task4.LRUcache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sirma.itt.javacourse.Utils;

/**
 * @param <K>
 * @param <V>
 * @author simeon
 */
public class LRUTailCache<K, V> {

	private Map<K, V> cache;
	private List<K> tail;
	private int maxElementts;

	/**
	 * @param maxElementts
	 */
	public LRUTailCache(int maxElementts) {
		this.maxElementts = maxElementts;
		cache = new HashMap<K, V>(maxElementts);
		tail = new ArrayList<K>();
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean addElement(K key, V value) {
		if (cache.containsKey(key)) {
			hitElement(key);
			Utils.printConsoleMessage("Hit");
			return false;
		} else if (maxElementts > cache.size()) {
			insertEllment(key, value);
			Utils.printConsoleMessage("Miss");
			return true;
		} else {
			K lastElement = tail.get(tail.size() - 1);
			removeElementByKey(lastElement);
			insertEllment(key, value);
			Utils.printConsoleMessage("Miss");
			return true;
		}
	}

	private void insertEllment(K key, V value) {
		cache.put(key, value);
		tail.add(0, key);
	}

	/**
	 * @param key
	 * @return
	 */
	public V getElement(K key) {
		if (cache.containsKey(key)) {
			hitElement(key);
		}
		return cache.get(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean removeElementByKey(K key) {
		if (cache.containsKey(key)) {
			cache.remove(key);
			tail.remove(key);
			return true;
		}
		return false;
	}

	/**
	 * @param key
	 */
	private void hitElement(K key) {
		int i = tail.indexOf(key);
		K tmp = tail.get(i);
		tail.remove(i);
		tail.add(0, tmp);
	}

	public Collection<V> getAllElements() {
		return cache.values();
	}
}
