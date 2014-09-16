package com.sirma.itt.javacourse.desingPatterns.task4.objectPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Pool class that lets us get N user objects.
 * 
 * @author Simeon Iliev
 */
public class UserPool {

	private static UserPool instance;

	private int capacaty = 5;

	private List<User> userPoolFreeInstances;
	private List<User> userPoolUsedInstances;

	/**
	 * Private constructor.
	 */
	private UserPool() {
		userPoolFreeInstances = new ArrayList<User>(capacaty);
		userPoolUsedInstances = new ArrayList<User>(capacaty);
	}

	/**
	 * Creates or Returns the existing instance of {@link UserPool}.
	 * 
	 * @return an instance of {@link UserPool}
	 */
	public static UserPool getInstance() {
		if (instance == null) {
			instance = new UserPool();
		}

		return instance;
	}

	/**
	 * Creates or returns an existing instance of the {@link User} class object.
	 * 
	 * @return an {@link User} object instance
	 * @throws NoMoreResourcesExceptio
	 *             When there are no more available resources to get.
	 */
	public User aquareUser() throws NoMoreResourcesException {
		if (userPoolUsedInstances.size() > capacaty) {
			throw new NoMoreResourcesException("Pool can't return instance");
		}
		if (userPoolFreeInstances.size() == 0) {
			userPoolFreeInstances.add(new User("This is important"));
		}
		User user = userPoolFreeInstances.get(0);
		userPoolUsedInstances.add(user);
		userPoolFreeInstances.remove(user);
		return user;
	}

	/**
	 * Releases the given user and moves him to the available resource pool
	 * 
	 * @param user
	 *            The user that is to released.
	 */
	public void releseUser(User user) {
		userPoolUsedInstances.remove(user);
		user.setPassword(null);
		user.setUserName(null);
		userPoolFreeInstances.add(user);

	}
}