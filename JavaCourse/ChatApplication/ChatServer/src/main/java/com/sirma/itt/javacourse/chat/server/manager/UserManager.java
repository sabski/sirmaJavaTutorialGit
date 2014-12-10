package com.sirma.itt.javacourse.chat.server.manager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;

/**
 * A singleton class that its purpose is to keep an accurate list of the current
 * users that are logged on to the server.
 * 
 * 
 * @author siliev
 * 
 */
public class UserManager {

	private static Logger log = Logger.getLogger(UserManager.class);
	private static UserManager instance;
	private Map<String, ChatUser> userMap;

	/**
	 * This method returns the only instance of this class.
	 * 
	 * @return the sole instance of this class.
	 */
	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}

	/**
	 * Private constructor.
	 */
	private UserManager() {
		userMap = new HashMap<String, ChatUser>();
	}

	/**
	 * Adds a {@link ChatUser} to the map of users.
	 * 
	 * @param user
	 *            the user to be added to the map.
	 * @return true if the user was added false if there is a user with the same
	 *         name logged on.
	 */
	public boolean addUser(ChatUser user) {
		if (isValidName(user.getUsername())) {
			userMap.put(user.getUsername(), user);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Removes a user from the map.
	 * 
	 * @param user
	 *            the user to be removed.
	 */
	public void removeUser(ChatUser user) {
		userMap.remove(user.getUsername());
	}

	/**
	 * Checks if there is a user on the server with the given username
	 * 
	 * @param userName
	 *            the username we want to check.
	 * @return true if there is no user with the given username, false if there
	 *         is a user with this username.
	 */
	public boolean isValidName(String userName) {
		if (userMap.keySet() != null) {
			for (String key : userMap.keySet()) {
				if (key.equalsIgnoreCase(userName)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Retrieves a {@link ChatUser} from the manager.
	 * 
	 * @param userName
	 *            the user we want to retrieve by given user name.
	 * @return the {@link ChatUser} object or null if there is no user with this
	 *         username.
	 */
	public ChatUser getUser(String userName) {
		return userMap.get(userName);
	}

}
