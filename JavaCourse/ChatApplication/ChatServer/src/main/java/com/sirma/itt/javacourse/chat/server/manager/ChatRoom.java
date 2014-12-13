package com.sirma.itt.javacourse.chat.server.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * 
 * @author siliev
 * 
 */
public class ChatRoom {

	private static Logger log = Logger.getLogger(ChatRoom.class);
	private static long chatRoomCount = 0;

	private Long id;
	private List<ClientListenerThread> userList;

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
	}

	/**
	 * Adds a new user to the current chat room.
	 * 
	 * @param user
	 *            to be added to the chat.
	 */
	public void addUser(ClientListenerThread user) {
		userList.add(user);
	}

	public void sendMessage(Message message) {
		for (ClientListenerThread user : userList) {
			user.sendMessge(message);
		}
	}

}
