package com.sirma.itt.javacourse.chat.server.manager;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;
import com.sirma.itt.javacourse.chat.server.threads.ClientListenerThread;

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
	public ServerMessageInterpreter(UserManager manager,
			ChatRoomManager chatRoomManager) {
		this.chatRoomManager = chatRoomManager;
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

	/**
	 * Creates a new chat room with the selected users.
	 * 
	 * @param message
	 *            the message that contains the users of the chat rooms.
	 * @param user
	 *            the user that wants to start a new chat room.
	 */
	private synchronized void createNewChatRoom(Message message, ChatUser user) {
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

	/**
	 * 
	 * 
	 * @param message
	 *            the disconnect message that disconnects the user.
	 */
	private synchronized void disconnect(Message message) {
		// TODO disconnect the user and notify other users
		// that this user has left the server.
		LOGGER.info("Recieved dissconet message still dont know what to do with it :/");
		chatRoomManager
				.removeUserFromChats(manager.getUser(message.getAuthor()));
		manager.removeUser(manager.getUser(message.getAuthor()).getUser());
		chatRoomManager.getCommonRoom().sendMessage(
				new Message(message.getAuthor(), chatRoomManager
						.getCommonRoom().getId(), MessageType.USERLISTREMOVE,
						MessageType.SERVER.toString()));
	}

	@Override
	public Message generateMessage(MessageType type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

	public Message generateStartChatMessage(Long id, String author,
			String userList) {
		return new Message(userList, id, MessageType.STARTCHAT, author);
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
	private synchronized void registerUser(Message message, ChatUser user) {
		if (manager.isValidName(message.getContent())) {
			manager.registerUser(user);
			ClientListenerThread newUser = manager.getUser(user.getUsername());
			chatRoomManager.getCommonRoom().sendMessage(
					new Message(newUser.getUser().getUsername(),
							chatRoomManager.getCommonRoom().getId(),
							MessageType.USERLISTADD, MessageType.SERVER
									.toString()));
			chatRoomManager.getCommonRoom().addUser(newUser);
			newUser.sendMessage(new Message(manager.getUserList().toString(),
					chatRoomManager.getCommonRoom().getId(),
					MessageType.USERLIST, MessageType.SERVER.toString()));
		} else {
			manager.rejectUser(user);
		}
	}
}
