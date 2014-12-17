package com.sirma.itt.javacourse.threads.task6.timeouthashtable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Class that will store objects with a key value to them. The object will be stored for a specific
 * amount of time or a default time.
 * 
 * @author Simeon Iliev
 */
public class TimeoutHashtable {

	private final Map<String, Object> timeOutMap;
	private long timeout = 1000L;
	private final List<TimingThread> threads;

	/**
	 * Constructor for the table with given timeout.
	 * 
	 * @param timeout
	 *            the time for the objects to live in milliseconds.
	 */
	public TimeoutHashtable(long timeout) {
		this.timeOutMap = new Hashtable<String, Object>();
		this.timeout = timeout;
		threads = new ArrayList<TimingThread>();
	}

	/**
	 * Puts the specific combination of key and value into the map, if there is already a value with
	 * the same key it is overwritten and its timeout reset.
	 * 
	 * @param key
	 *            The key to the object.
	 * @param value
	 *            The specific object value we are inserting into the map.
	 * @return the previous value of the key or null if there is none.
	 */
	public Object put(String key, Object value) {
		TimingThread thread = null;
		if (timeOutMap.containsKey(key)) {
			for (TimingThread threadFor : threads) {
				if (threadFor.getKey().equals(key)) {
					threadFor.updateTime();
					break;
				}
			}
		} else {
			thread = new TimingThread(timeout, key, this);
			threads.add(thread);
			thread.start();
		}
		return timeOutMap.put(key, value);
	}

	/**
	 * Retrieves the object value that is associated with this key, if there is no value associated
	 * with the key returns null value.
	 * 
	 * @param key
	 *            The key to the object.
	 * @return the object value in the map or null if there is no value.
	 */
	public Object get(String key) {
		if (timeOutMap.containsKey(key)) {
			for (TimingThread t : threads) {
				if (t.getKey().equals(key)) {
					t.updateTime();
					break;
				}
			}
		}
		return timeOutMap.get(key);
	}

	/**
	 * Removes an object from the map and also returns the removed objects value. The object is
	 * removed using its key, however if there is no value in the map the method will return a null
	 * object, also this map allows null values so it also may return null if the object value is
	 * equal to null.
	 * 
	 * @param key
	 *            The key to the object.
	 * @return the object value in the map or null if there is no value.
	 */
	public Object remove(String key) {
		if (timeOutMap.containsKey(key)) {
			for (TimingThread t : threads) {
				if (t.getKey().equals(key)) {
					removeThread(t);
					break;
				}
			}
		}
		return timeOutMap.remove(key);
	}

	/**
	 * Removes threads that have timeout.
	 * 
	 * @param thread
	 *            The thread that has timeout.
	 */
	public void removeThread(Thread thread) {
		if (threads.contains(thread)) {
			threads.remove(thread);
		}
	}

	@Override
	public String toString() {
		return timeOutMap.toString();
	}

}
