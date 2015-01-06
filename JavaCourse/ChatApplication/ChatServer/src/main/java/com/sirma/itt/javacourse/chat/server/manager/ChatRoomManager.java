package com.sirma.itt.javacourse.chat.server.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

/**
 * This class manages the chat rooms on the server.
 * 
 * @author siliev
 * 
 */
public class ChatRoomManager {
	private static final Logger LOGGER = Logger
			.getLogger(ChatRoomManager.class);
	private static ChatRoomManager instance;
	private Map<Long, ChatRoom> chatRooms;
	private List<ChatRoom> freeRooms;
	private ChatRoom commonRoom;

	/**
	 * Singleton constructor.
	 */
	private ChatRoomManager() {
		chatRooms = new HashMap<Long, ChatRoom>(100);
		freeRooms = new ArrayList<ChatRoom>(20);
		createCommonRoom();
	}

	/**
	 * Singleton method to get the class instance;
	 * 
	 * @return the sole instance of this class.
	 */
	public static ChatRoomManager getInstance() {
		if (instance == null) {
			instance = new ChatRoomManager();
		}
		return instance;
	}

	/**
	 * Creates a new chatRoom and returns the id of the room for reference to
	 * that room.
	 * 
	 * @return the id of the created room.
	 */
	public Long createChatRoom() {
		ChatRoom chatRoom;
		if (freeRooms.isEmpty()) {
			chatRoom = new ChatRoom();
		} else {
			chatRoom = freeRooms.get(0);
			chatRoom.getUsers().clear();
		}
		chatRooms.put(chatRoom.getId(), chatRoom);
		return chatRoom.getId();
	}

	/**
	 * Searches for a room by its id.
	 * 
	 * @param id
	 *            the id of the room we are searching.
	 * @return the value to which the specified id is mapped, or null if there
	 *         is no mapping for the key.
	 */
	public ChatRoom getRoomById(Long id) {
		return chatRooms.get(id);
	}

	/**
	 * Creates the common room which is sent to all the users.
	 */
	public void createCommonRoom() {
		commonRoom = new ChatRoom();
		chatRooms.put(commonRoom.getId(), commonRoom);
	}

	/**
	 * Returns the common room. This is the room for all the users.
	 * 
	 * @return the common room.
	 */
	public ChatRoom getCommonRoom() {
		return commonRoom;
	}

	/**
	 * Searches for a user that has disconnected and removes him from the chat
	 * rooms he is in.
	 * 
	 * @param user
	 *            the user to be removed from chats.
	 */
	public void removeUserFromChats(ClientListenerThread user) {
		LOGGER.info("Searching for users to remove");
		if (!chatRooms.isEmpty()) {
			for (Entry<Long, ChatRoom> room : chatRooms.entrySet()) {
				if (room.getValue().containsUser(user.getUser().getUsername())) {
					room.getValue().removeUser(user);
					LOGGER.info("Removed user");
					if (room.getValue().isChatRoomEmpty()) {
						chatRooms.remove(room);
						freeRooms.add(room.getValue());
					}
				}
			}
		}
	}
}
