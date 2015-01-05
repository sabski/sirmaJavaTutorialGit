package com.sirma.itt.javacourse.chat.server.manager;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * This class represent a single chat room in the application. The idea of this
 * class is to hold a user list and send messages between these users.
 * 
 * @author siliev
 * 
 */
public class ChatRoom {

	private static long chatRoomCount = 0;

	private Long id;
	private List<ClientListenerThread> userList;
	private List<String> usernameList;

	/**
	 * @return the id
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
	public void sendMessage(Message message) {
		for (ClientListenerThread user : userList) {
			user.sendMessge(message);
		}
	}

	public List<String> getUsers() {
		return usernameList;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean containsUser(String user) {
		return usernameList.contains(user);
	}

	/**
	 * 
	 * 
	 * @param user
	 *            the user we want to remove from the chat room.
	 */
	public void removeUser(ClientListenerThread user) {
		userList.remove(user);
		usernameList.remove(user.getUser().getUsername());
		sendMessage(new Message(user.getUser().getUsername(), id,
				TYPE.DISCONNECT, TYPE.SERVER.toString()));
	}

	public boolean isChatRoomEmpty() {
		if (id == 0 || userList.size() > 1) {
			return false;
		}

		return true;
	}
}
