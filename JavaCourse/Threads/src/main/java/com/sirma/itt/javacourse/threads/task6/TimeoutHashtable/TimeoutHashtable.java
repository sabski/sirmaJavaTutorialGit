package com.sirma.itt.javacourse.threads.task6.TimeoutHashtable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Simeon Iliev
 */
public class TimeoutHashtable {

	private Map<String, Object> timeOutMap;
	private long timeout;

	/**
	 * @param timeout
	 */
	public TimeoutHashtable(long timeout) {
		this.timeOutMap = new ConcurrentHashMap<String, Object>();
		this.timeout = timeout;
	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		timeOutMap.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return timeOutMap.get(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public Object remove(String key) {
		return timeOutMap.remove(key);
	}
}
