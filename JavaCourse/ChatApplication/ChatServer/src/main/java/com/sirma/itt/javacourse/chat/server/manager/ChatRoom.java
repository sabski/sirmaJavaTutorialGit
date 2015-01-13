package com.sirma.itt.javacourse.chat.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * This class represent a single chat room in the application. The idea of this
 * class is to hold a user list and send messages between these users.
 * 
 * @author siliev
 * 
 */
public class ChatRoom {

	private static final Logger LOGGER = Logger.getLogger(ChatRoom.class);
	private static long chatRoomCount = 0;

	private Long id;
	private List<ClientListenerThread> userList;
	private List<String> usernameList;

	/**
	 * @return the id of the chat room.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Constructor that start a chat room initiates the id of the room.
	 */
	public ChatRoom() {
		id = chatRoomCount++;
		userList = new ArrayList<ClientListenerThread>();
		usernameList = new ArrayList<String>();
	}

	/**
	 * Adds a new user to the current chat room.
	 * 
	 * @param user
	 *            to be added to the chat.
	 */
	public void addUser(ClientListenerThread user) {
		userList.add(user);
		usernameList.add(user.getUser().getUsername());
	}

	/**
	 * Sends a given message to all the users in the chat room.
	 * 
	 * @param message
	 *            the message that is to be sent to the users.
	 */
	public synchronized void sendMessage(Message message) {
		for (ClientListenerThread user : userList) {
			user.sendMessage(message);
		}
	}

	/**
	 * 
	 * @return the list of user for the chatroom.
	 */
	public List<String> getUsers() {
		return usernameList;
	}

	/**
	 * Checks the room if it contains a user by his username.
	 * 
	 * @param user
	 *            the user we want to check is in the room.A
	 * 
	 * @return true if the user is in the list, false otherwise.
	 */
	public boolean containsUser(String user) {
		return usernameList.contains(user);
	}

	/**
	 * Removes the user from the chat.
	 * 
	 * @param user
	 *            the user we want to remove from the chat room.
	 */
	public void removeUser(ClientListenerThread user) {
		LOGGER.info("Removing user" + user.getUser().getUsername());
		userList.remove(user);
		usernameList.remove(user.getUser().getUsername());
		sendMessage(new Message(user.getUser().getUsername(), id,
				MessageType.DISCONNECT, MessageType.SERVER.toString()));
	}

	/**
	 * Checks if the current chat room is empty.
	 * 
	 * @return true if there are no users in the room, false if there is at
	 *         least one user in the room.
	 */
	public boolean isChatRoomEmpty() {
		if (id == 0 || userList.size() > 0) {
			return false;
		}
		return true;
	}
}
