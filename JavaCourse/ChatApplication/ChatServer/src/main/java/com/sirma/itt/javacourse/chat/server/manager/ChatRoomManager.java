package com.sirma.itt.javacourse.chat.server.manager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siliev
 * 
 */
public class ChatRoomManager {

	private static ChatRoomManager instance;
	private Map<Long, ChatRoom> chatRooms;

	private ChatRoomManager() {
		chatRooms = new HashMap<Long, ChatRoom>();
	}

	public static ChatRoomManager getInstance() {
		if (instance == null) {
			instance = new ChatRoomManager();
		}
		return instance;
	}

	public Long createChatRoom() {
		ChatRoom chatRoom = new ChatRoom();
		chatRooms.put(chatRoom.getId(), chatRoom);
		return chatRoom.getId();
	}

	
	public ChatRoom getRoomById(Long id) {
		return chatRooms.get(id);
	}
}
