package com.sirma.itt.javacourse.chat.server.manager;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;

/**
 * Interprets the received server messages from the clients.
 * 
 * 
 * @author siliev
 * 
 */
public class ServerMessageInterpreter implements MessageInterpreter {

	private static Logger log = Logger
			.getLogger(ServerMessageInterpreter.class);

	private UserManager manager;
	private ChatRoomManager chatRoomManager;

	/**
	 * Constructor for the message interpreter.
	 * 
	 * @param manager
	 *            the user manager of the server.
	 */
	public ServerMessageInterpreter(UserManager manager) {
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
			chatRoomManager.getRoomById(empyRoom).addUser(
					manager.getUser(user.getUsername()));
			chatRoomManager.getRoomById(empyRoom).addUser(
					manager.getUser(message.getContent()));
			break;
		default:
			log.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	@Override
	public Message generateMessage(TYPE type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

	/**
	 * Checks if the client can register on to the server if the client can
	 * register onto the server, if that is not possible the server sends a
	 * reject message to the user.
	 * 
	 * @param message
	 *            the message that the user has sent us.
	 * @param user
	 *            that want to register to the server.
	 */
	private void registerUser(Message message, ChatUser user) {
		if (manager.isValidName(message.getContent())) {
			manager.registerUser(user);
			chatRoomManager.getCommonRoom().addUser(
					manager.getUser(user.getUsername()));
		} else {
			manager.rejectUser(user);
		}
	}
}
