package com.sirma.itt.javacourse.chat.client.managers;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.controller.UIControler;
import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * Interprets the messages received from the server.
 * 
 * @author siliev
 * 
 */
public class ClientMessageInterpretor implements MessageInterpreter {

	private static final Logger LOGGER = Logger
			.getLogger(ClientMessageInterpretor.class);
	private UIControler controller;
	private ClientInfo client;

	public ClientMessageInterpretor(UIControler controller) {
		client = ClientInfo.getInstance();
		this.controller = controller;
	}

	@Override
	public Message generateMessage(MessageType type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

	@Override
	public void interpretMessage(Message message, ChatUser user) {

		switch (message.getMessageType()) {
		case MESSAGE:
			displayMessage(message);
			break;
		case STARTCHAT:
			createNewChatWindow(message);
			break;
		case APPROVED:
			clientApprover(message);
			break;
		case REFUSED:
			serverRefused(message);
			break;
		case USERLISTADD:
			LOGGER.info(message);
			controller.updateUserListAdd(message);
			break;
		case USERLIST:
			LOGGER.info(message);
			controller.updateUserList(message.getContent());
			break;
		case USERLISTREMOVE:
			LOGGER.info(message);
			controller.updateUserListRemove(message.getContent());
			break;
		case DISCONNECT:
			LOGGER.info(message);
			message.setContent(LanguageController.getWord("disconnectmessage")
					+ " " + message.getContent());
			displayMessage(message);
			break;
		default:
			LOGGER.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	/**
	 * Shows that the server has refused the client.
	 * 
	 * @param message
	 *            the message that was received from the server.
	 */
	protected void serverRefused(Message message) {

		controller.userNameRejected(message);
	}

	/**
	 * Shows that the server has approved the client.
	 * 
	 * @param message
	 *            the message that was received from the server.
	 */
	protected void clientApprover(Message message) {
		client.setUserName(message.getAuthor());
		controller.welcomeClient(message);
	}

	/**
	 * Redirects the message to where it can be properly displayed.
	 * 
	 * @param message
	 *            the message that is to be displayed.
	 */
	protected void displayMessage(Message message) {
		LOGGER.info("Message reseived : " + message);
		controller.displayMessage(message);
	}

	/**
	 * Creates a new chat tab for a chat with one or multiple users.
	 * 
	 * @param message
	 *            the message to create a new chat window and the data needed to
	 *            create the room.
	 */
	protected void createNewChatWindow(Message message) {
		LOGGER.info("Creating new chat room " + message);
		controller.createTab(message);
	}
}
