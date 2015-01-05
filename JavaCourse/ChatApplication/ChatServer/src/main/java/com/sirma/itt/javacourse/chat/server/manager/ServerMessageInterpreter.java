package com.sirma.itt.javacourse.chat.server.manager;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;

/**
 * Interprets the received server messages from the clients.
 * 
 * 
 * @author siliev
 * 
 */
public class ServerMessageInterpreter implements MessageInterpreter {

	private static final Logger LOGGER = Logger
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
		LOGGER.info(message);
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
			disconnect(message);
			break;
		case STARTCHAT:
			createNewChatRoom(message, user);
			break;
		default:
			LOGGER.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	private void createNewChatRoom(Message message, ChatUser user) {
		Long empyRoom = chatRoomManager.createChatRoom();
		chatRoomManager.getRoomById(empyRoom).addUser(
				manager.getUser(user.getUsername()));
		String[] results = CommonUtils.splitList(message.getContent());
		for (String users : results) {
			chatRoomManager.getRoomById(empyRoom).addUser(
					manager.getUser(users));
		}
		chatRoomManager.getRoomById(empyRoom).sendMessage(
				generateStartChatMessage(empyRoom, user.getUsername(),
						message.getContent()));
	}

	private void disconnect(Message message) {
		// TODO disconnect the user and notify other users
		// that this user has left the server.
		LOGGER.info("Recieved dissconet message still dont know what to do with it :/");
		manager.removeUser(manager.getUser(message.getAuthor()).getUser());
		chatRoomManager
				.removeUserFromChats(manager.getUser(message.getAuthor()));
		chatRoomManager.getCommonRoom().sendMessage(
				new Message(manager.getUserList().toString(), chatRoomManager
						.getCommonRoom().getId(), TYPE.USERLIST, TYPE.SERVER
						.toString()));

	}

	@Override
	public Message generateMessage(TYPE type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

	public Message generateStartChatMessage(Long id, String author,
			String userList) {
		return new Message(userList, id, TYPE.STARTCHAT, author);
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
			chatRoomManager.getCommonRoom().sendMessage(
					new Message(manager.getUserList().toString(),
							chatRoomManager.getCommonRoom().getId(),
							TYPE.USERLIST, TYPE.SERVER.toString()));
		} else {
			manager.rejectUser(user);
		}
	}
}
