package com.sirma.itt.javacourse.chat.server.manager;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.MessageInterpretor;

/**
 * 
 * @author siliev
 * 
 */
public class ServerMessageInterpretor implements MessageInterpretor {

	private static Logger log = Logger
			.getLogger(ServerMessageInterpretor.class);

	private UserManager manager;
	private ChatRoomManager chatRoomManager;

	public ServerMessageInterpretor(UserManager manager) {
		chatRoomManager = ChatRoomManager.getInstance();
		this.manager = manager;
	}

	@Override
	public void interpretMessage(Message message, ChatUser user) {
		switch (message.getMessageType()) {
		case CONNECT:
			user.setUsername(message.getContent());
			registerUser(message, user);
			break;
		case MESSAGE:
			chatRoomManager.getRoomById(message.getChatRoomId()).sendMessage(
					message);
			break;
		case DISCONNECT:

			break;
		case STARTCHAT:
			Long empyRoom = chatRoomManager.createChatRoom();
			chatRoomManager.getRoomById(empyRoom).addUser(manager.getUser(user.getUsername()));
			chatRoomManager.getRoomById(empyRoom).addUser(manager.getUser(message.getContent()));			
			break;
		default:
			log.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	private void registerUser(Message message, ChatUser user) {
		if (manager.isValidName(message.getContent())) {
			manager.registerUser(user);
		} else {
			manager.rejectUser(user);
		}
	}

	@Override
	public Message generateMessage(TYPE type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

}
