package com.sirma.itt.javacourse.desing_patterns.task4.object_pool;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Pool class that lets us get N user objects.
 * 
 * @param <T>
 *            The type parameter this class will use.
 * @author Simeon Iliev
 */
public class UserPool<T> implements Pool<T> {

	private static Logger log = Logger.getLogger(UserPool.class.getName());

	private static int capacaty = 10;
	private final T instance;
	private final List<T> freeInstances;
	private final List<T> usedInstances;

	public UserPool(T instance) {
		freeInstances = new ArrayList<T>(capacaty + 1);
		usedInstances = new ArrayList<T>(capacaty + 1);
		this.instance = instance;
	}

	@Override
	public T acquire() throws NoMoreResourcesException {
		if (usedInstances.size() > capacaty) {
			throw new NoMoreResourcesException("Pool can't return instance");
		}
		T user;
		if (freeInstances.size() != 0) {
			user = freeInstances.get(0);
			usedInstances.add(user);
			freeInstances.remove(0);
		} else {
			user = initObject();
			usedInstances.add(user);
		}
		return user;
	}

	@Override
	public void release(T object) throws NoMoreResourcesException {
		if (freeInstances.size() == capacaty) {
			throw new NoMoreResourcesException("All instances are free");
		}
		usedInstances.remove(object);
		freeInstances.add(object);
	}

	@Override
	public T initObject() {
		Class<T> object = (Class<T>) instance.getClass();
		try {
			return object.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
