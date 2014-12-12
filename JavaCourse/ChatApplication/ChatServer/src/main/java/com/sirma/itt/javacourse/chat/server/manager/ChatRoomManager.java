package com.sirma.itt.javacourse.chat.server.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siliev
 * 
 */
public class ChatRoomManager {

	private static ChatRoomManager instance;
	private List<ChatRoom> chatRooms;

	private ChatRoomManager() {
		chatRooms = new ArrayList<ChatRoom>();
	}

	public ChatRoomManager getInstance() {
		if (instance == null) {
			instance = new ChatRoomManager();

		}
		return instance;
	}
	
	
}
