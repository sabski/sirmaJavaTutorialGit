package com.sirma.itt.javacourse.desingPatterns.task4.objectPool;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Pool class that lets us get N user objects.
 * 
 * @author Simeon Iliev
 * @param <T>
 */
public class UserPool<T> implements Pool<T> {

	private static Logger log = Logger.getLogger(UserPool.class.getName());

	private static int capacaty = 5;
	private final T instance;
	private final List<T> userPoolFreeInstances;
	private final List<T> userPoolUsedInstances;

	/**
	 * Private constructor.
	 */
	public UserPool(T instance) {
		userPoolFreeInstances = new ArrayList<T>(capacaty + 1);
		userPoolUsedInstances = new ArrayList<T>(capacaty + 1);
		this.instance = instance;
	}

	@Override
	public T acquire() throws NoMoreResourcesException {
		if (userPoolUsedInstances.size() > capacaty) {
			throw new NoMoreResourcesException("Pool can't return instance");
		}
		if (userPoolFreeInstances.size() == 0) {
			try {
				userPoolFreeInstances.add(initObject());
			} catch (InstantiationException e) {
				log.error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
			}
		}
		T user = userPoolFreeInstances.get(0);
		userPoolUsedInstances.add(user);
		userPoolFreeInstances.remove(user);
		return user;
	}

	@Override
	public void release(T object) {
		if (object == null) {
			try {
				object = acquire();
			} catch (NoMoreResourcesException e) {
				log.error(e.getMessage(), e);
			}
		}
		userPoolUsedInstances.remove(object);
		userPoolFreeInstances.add(object);
	}

	@Override
	public T initObject() throws InstantiationException, IllegalAccessException {
		Class<T> object = (Class<T>) instance.getClass();
		return object.newInstance();
	}

}
