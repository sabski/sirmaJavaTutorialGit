package com.sirma.itt.javacourse.chat.server.manager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;
import com.sirma.itt.javacourse.chat.common.exceptions.ChatException;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * A singleton class that its purpose is to keep an accurate list of the current
 * users that are logged on to the server.
 * 
 * 
 * @author siliev
 * 
 */
public class UserManager {

	private static final Logger LOGGER = Logger.getLogger(UserManager.class);

	private static UserManager instance;
	private Map<String, ClientListenerThread> userMap;
	private List<ClientListenerThread> tempHolder;
	private MessageInterpreter interpretator;
	private ChatRoomManager manager;

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
		userMap = new HashMap<String, ClientListenerThread>();
		tempHolder = new ArrayList<ClientListenerThread>();
		interpretator = new ServerMessageInterpreter(this);
		manager = ChatRoomManager.getInstance();
	}

	/**
	 * Adds a {@link ChatUser} to the map of users.
	 * 
	 * @param user
	 *            the user to be added to the map.
	 * @return true if the user was added false if there is a user with the same
	 *         name logged on.
	 */
	public boolean addUser(ClientListenerThread user) {
		if (isValidName(user.getUser().getUsername())) {
			userMap.put(user.getUser().getUsername(), user);
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
	 * Checks if there is a user on the server with the given username.
	 * 
	 * @param userName
	 *            the username we want to check.
	 * @return true if there is no user with the given username, false if there
	 *         is a user with this username.
	 */
	public boolean isValidName(String userName) {
		if (userName.contains("[") || userName.contains("]")) {
			return false;
		}
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
	public ClientListenerThread getUser(String userName) {
		return userMap.get(userName);
	}

	/**
	 * Starts the process of registering the user to the server.
	 * 
	 * @param client
	 *            the client to be registered.
	 */
	public void acceptUser(Socket client) {
		ChatUser user = new ChatUser(null, client);
		ClientListenerThread listener;
		try {
			listener = new ClientListenerThread(user);
			listener.start();
			tempHolder.add(listener);
		} catch (ChatException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves the current {@link MessageInterpreter}.
	 * 
	 * 
	 * @return the message interpreter.
	 */
	public MessageInterpreter getInterpretator() {
		return interpretator;
	}

	/**
	 * Registers a user on the server and sends him the current user list and
	 * the common room chat.
	 * 
	 * @param user
	 *            the user to be registered on the server.
	 */
	public void registerUser(ChatUser user) {
		for (ClientListenerThread thread : tempHolder) {
			if (thread.getUser().equals(user)) {
				tempHolder.remove(thread);
				userMap.put(user.getUsername(), thread);
				LOGGER.info("Registering user " + user.getUsername());
				thread.sendMessage(interpretator.generateMessage(TYPE.APPROVED,
						0, thread.getUser().getUsername(), thread.getUser()
								.getUsername()));
				thread.sendMessage(interpretator.generateMessage(
						TYPE.STARTCHAT, manager.getCommonRoom().getId(),
						manager.getCommonRoom().getUsers().toString(),
						TYPE.SERVER.toString()));
				break;
			}
		}
	}

	/**
	 * Rejects the user for invalid username.
	 * 
	 * @param user
	 *            the user to send a {@link TYPE.REFUSED}.
	 */
	public void rejectUser(ChatUser user) {
		for (ClientListenerThread thread : tempHolder) {
			if (thread.getUser().getUsername().equals(user.getUsername())) {
				LOGGER.info("Rejecting user " + user.getUsername());
				thread.sendMessage(interpretator.generateMessage(TYPE.REFUSED,
						0, "The user name you entered is invalid : "
								+ thread.getUser().getUsername(),
						TYPE.SERVER.toString()));
				break;
			}
		}
	}

	/**
	 * Returns the {@link ClientListenerThread} that is associated with a
	 * client.
	 * 
	 * @param name
	 *            the name of the client we are looking for.
	 * @return the thread that is associated with a client.
	 */
	public ClientListenerThread getClientThreadByName(String name) {
		return userMap.get(name);
	}

	/**
	 * Retrieves the user list of registered users on the server.S
	 * 
	 * 
	 * @return the list of connected users that are on the server.
	 */
	public List<String> getUserList() {
		List<String> list = new ArrayList<String>(userMap.keySet());
		return list;
	}

	/**
	 * Disconnects the user from the chats he is into.
	 * 
	 * @param user
	 *            removes the user from chats.
	 */
	public void disconnectUser(ClientListenerThread user) {
		manager.removeUserFromChats(user);
	}
}
